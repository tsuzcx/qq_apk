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
  ProgressDialog jdField_a_of_type_AndroidAppProgressDialog;
  private final WeakReference<PhotoListCustomization<? extends OtherCommonData>> jdField_a_of_type_JavaLangRefWeakReference;
  
  public NewPhotoListActivityHandler(PhotoListCustomization<? extends OtherCommonData> paramPhotoListCustomization)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramPhotoListCustomization);
  }
  
  public void a()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidAppProgressDialog != null)
      {
        b();
      }
      else
      {
        this.jdField_a_of_type_AndroidAppProgressDialog = new ReportProgressDialog(((PhotoListCustomization)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity, 2131756189);
        this.jdField_a_of_type_AndroidAppProgressDialog.setCancelable(true);
        this.jdField_a_of_type_AndroidAppProgressDialog.setCanceledOnTouchOutside(false);
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
        this.jdField_a_of_type_AndroidAppProgressDialog.setContentView(2131559561);
        ((TextView)this.jdField_a_of_type_AndroidAppProgressDialog.findViewById(2131372646)).setText("");
        if (QLog.isColorLevel()) {
          QLog.d("QQAlbum", 2, "showProgressDialog");
        }
      }
      if (!this.jdField_a_of_type_AndroidAppProgressDialog.isShowing())
      {
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
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
    ProgressDialog localProgressDialog = this.jdField_a_of_type_AndroidAppProgressDialog;
    if ((localProgressDialog != null) && (localProgressDialog.isShowing())) {
      this.jdField_a_of_type_AndroidAppProgressDialog.cancel();
    }
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject1 = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject1 != null)
    {
      if (((WeakReference)localObject1).get() == null) {
        return;
      }
      Object localObject2 = (PhotoListCustomization)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      localObject1 = ((PhotoListCustomization)localObject2).jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList;
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
                QQAlbumUtils.a((PhotoListCustomization)this.jdField_a_of_type_JavaLangRefWeakReference.get());
                QQAlbumUtils.a(((PhotoListCustomization)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity, str2);
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
              if (paramMessage.size() < ((PhotoListCustomization)localObject2).jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum)
              {
                paramMessage.add(str1);
                QQAlbumUtils.a((PhotoListCustomization)this.jdField_a_of_type_JavaLangRefWeakReference.get());
              }
              else
              {
                QQToast.a(((PhotoListCustomization)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity, String.format(((PhotoListCustomization)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity.getResources().getString(2131694856), new Object[] { Integer.valueOf(((PhotoListCustomization)localObject2).jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum) }), 0).a();
              }
              QQAlbumUtils.a(((PhotoListCustomization)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity, str1);
            }
          }
          else
          {
            if ((((PhotoListCustomization)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity instanceof NewPhotoListActivity)) {
              b();
            }
            QLog.e("QQAlbum", 2, new Object[] { "onEncodeError = ", Integer.valueOf(((Integer)paramMessage.obj).intValue()) });
            QQToast.a(((PhotoListCustomization)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity, ((PhotoListCustomization)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity.getResources().getString(2131694860), 0).a();
          }
        }
        else {
          ((PhotoListCustomization)localObject2).a(paramMessage);
        }
      }
      else
      {
        localObject1 = ((PhotoListCustomization)localObject2).jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.a;
        if (localObject1 == null) {
          return;
        }
        localObject2 = new ArrayList();
        ((List)localObject2).addAll(((PhotoListAdapter)localObject1).a);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.NewPhotoListActivityHandler
 * JD-Core Version:    0.7.0.1
 */