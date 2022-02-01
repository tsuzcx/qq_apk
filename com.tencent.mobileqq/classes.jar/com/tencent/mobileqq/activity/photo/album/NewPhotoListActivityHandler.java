package com.tencent.mobileqq.activity.photo.album;

import android.app.ProgressDialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.photo.PeakFragmentActivity;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListAdapter;
import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomization;
import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListSceneBase;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class NewPhotoListActivityHandler
  extends Handler
{
  ProgressDialog a;
  private final WeakReference<PhotoListCustomization<? extends OtherCommonData>> b;
  
  public NewPhotoListActivityHandler(PhotoListCustomization<? extends OtherCommonData> paramPhotoListCustomization)
  {
    this.b = new WeakReference(paramPhotoListCustomization);
  }
  
  public void a()
  {
    try
    {
      if (this.a != null)
      {
        b();
      }
      else
      {
        this.a = new ReportProgressDialog(((PhotoListCustomization)this.b.get()).d, 2131953338);
        this.a.setCancelable(true);
        this.a.setCanceledOnTouchOutside(false);
        this.a.show();
        this.a.setContentView(2131625585);
        ((TextView)this.a.findViewById(2131440191)).setText("");
        if (QLog.isColorLevel()) {
          QLog.d("QQAlbum", 2, "showProgressDialog");
        }
      }
      if (!this.a.isShowing())
      {
        this.a.show();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      Logger.b("QQAlbum", "SendPhotoActivity.showProgressDialog", localThrowable.toString());
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQAlbum", 2, "cancleProgressDailog");
    }
    ProgressDialog localProgressDialog = this.a;
    if ((localProgressDialog != null) && (localProgressDialog.isShowing())) {
      this.a.cancel();
    }
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject1 = this.b;
    if (localObject1 != null)
    {
      if (((WeakReference)localObject1).get() == null) {
        return;
      }
      Object localObject2 = (PhotoListCustomization)this.b.get();
      localObject1 = ((PhotoListCustomization)localObject2).e.selectedPhotoList;
      int i = paramMessage.what;
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            String str1;
            if (i != 3)
            {
              if (i != 4) {
                return;
              }
              paramMessage = paramMessage.getData();
              str1 = paramMessage.getString("SRC_SAVE_PATH");
              String str2 = paramMessage.getString("DES_SAVE_PATH");
              if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
              {
                paramMessage = (Message)localObject1;
                if (localObject1 == null) {
                  paramMessage = new ArrayList();
                }
                QLog.d("QQAlbum", 2, new Object[] { "MSG_EDITED_PHOTO_SAVE_SUCCEED = ", str2 });
                i = paramMessage.indexOf(str1);
                if (i != -1) {
                  paramMessage.set(i, str2);
                }
                QQAlbumUtils.a((PhotoListCustomization)this.b.get());
                QQAlbumUtils.a(((PhotoListCustomization)localObject2).d, str2);
              }
            }
            else if ((paramMessage.obj instanceof String))
            {
              str1 = (String)paramMessage.obj;
              paramMessage = (Message)localObject1;
              if (localObject1 == null) {
                paramMessage = new ArrayList();
              }
              QLog.d("QQAlbum", 2, new Object[] { "MSG_PHOTO_ENCODE_SUCCEED = ", str1 });
              if (paramMessage.size() < ((PhotoListCustomization)localObject2).e.maxSelectNum)
              {
                paramMessage.add(str1);
                QQAlbumUtils.a((PhotoListCustomization)this.b.get());
              }
              else
              {
                QQToast.makeText(((PhotoListCustomization)localObject2).d, String.format(((PhotoListCustomization)localObject2).d.getResources().getString(2131892559), new Object[] { Integer.valueOf(((PhotoListCustomization)localObject2).e.maxSelectNum) }), 0).show();
              }
              QQAlbumUtils.a(((PhotoListCustomization)localObject2).d, str1);
            }
          }
          else
          {
            if ((((PhotoListCustomization)localObject2).d instanceof NewPhotoListActivity)) {
              b();
            }
            QLog.e("QQAlbum", 2, new Object[] { "onEncodeError = ", Integer.valueOf(((Integer)paramMessage.obj).intValue()) });
            QQToast.makeText(((PhotoListCustomization)localObject2).d, ((PhotoListCustomization)localObject2).d.getResources().getString(2131892563), 0).show();
          }
        }
        else {
          ((PhotoListCustomization)localObject2).a(paramMessage);
        }
      }
      else
      {
        localObject1 = ((PhotoListCustomization)localObject2).h.t;
        if (localObject1 == null) {
          return;
        }
        localObject2 = new ArrayList();
        ((List)localObject2).addAll(((PhotoListAdapter)localObject1).d);
        paramMessage = paramMessage.getData();
        i = paramMessage.getInt("ALBUMLIST_POSITION");
        long l = paramMessage.getLong("ALBUMLIST_ITEM_DURATION");
        paramMessage = (LocalMediaInfo)((List)localObject2).get(i);
        paramMessage.mDuration = l;
        ((List)localObject2).set(i, paramMessage);
        ((PhotoListAdapter)localObject1).a((List)localObject2);
        ((PhotoListAdapter)localObject1).notifyDataSetChanged();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.NewPhotoListActivityHandler
 * JD-Core Version:    0.7.0.1
 */