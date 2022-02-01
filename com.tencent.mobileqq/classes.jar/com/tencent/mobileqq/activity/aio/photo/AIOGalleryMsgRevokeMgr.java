package com.tencent.mobileqq.activity.aio.photo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.MsgRevokeListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.richmedia.RichmediaService;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import java.util.ArrayList;
import java.util.Iterator;

public class AIOGalleryMsgRevokeMgr
{
  private static AIOGalleryMsgRevokeMgr jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryMsgRevokeMgr;
  private final ArrayList<MsgRevokeListener> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public static AIOGalleryMsgRevokeMgr a()
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryMsgRevokeMgr == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryMsgRevokeMgr == null) {
          jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryMsgRevokeMgr = new AIOGalleryMsgRevokeMgr();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryMsgRevokeMgr;
  }
  
  public static void a(Activity paramActivity)
  {
    if (paramActivity != null) {
      try
      {
        localObject = DialogUtil.a(paramActivity, 230).setMessage(HardCodeUtil.a(2131700266)).setPositiveButton(paramActivity.getString(2131693890), new AIOGalleryMsgRevokeMgr.1(paramActivity));
        if ((localObject != null) && (!paramActivity.isFinishing()))
        {
          ((QQCustomDialog)localObject).show();
          return;
        }
      }
      catch (Throwable paramActivity)
      {
        Object localObject;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("showDialog exception: ");
          ((StringBuilder)localObject).append(paramActivity.getMessage());
          QLog.d("AIOGalleryMsgRevokeMgr", 0, ((StringBuilder)localObject).toString());
        }
      }
    }
  }
  
  public static void a(Activity paramActivity, RelativeLayout paramRelativeLayout)
  {
    if ((paramActivity != null) && (paramRelativeLayout != null))
    {
      ImageView localImageView = new ImageView(paramActivity);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localImageView.setImageResource(2130845247);
      localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      paramRelativeLayout.addView(localImageView, localLayoutParams);
      a(paramActivity);
      ReportController.b(null, "dc00898", "", "", "0X8009EB8", "0X8009EB8", 0, 0, "", "", "", "");
    }
  }
  
  public static void a(MessageRecord paramMessageRecord)
  {
    if (((paramMessageRecord instanceof MessageForPic)) || ((paramMessageRecord instanceof MessageForShortVideo)) || ((paramMessageRecord instanceof MessageForMarketFace)) || ((paramMessageRecord instanceof MessageForFile)) || ((paramMessageRecord instanceof MessageForTroopFile)) || ((paramMessageRecord instanceof MessageForMixedMsg)) || ((paramMessageRecord instanceof MessageForStructing)))
    {
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("sendMsgRevokeRequest:");
        ((StringBuilder)???).append(paramMessageRecord);
        QLog.i("AIOGalleryMsgRevokeMgr", 0, ((StringBuilder)???).toString());
      }
      Object localObject2 = a();
      if (localObject2 != null) {
        synchronized (((AIOGalleryMsgRevokeMgr)localObject2).jdField_a_of_type_JavaUtilArrayList)
        {
          localObject2 = ((AIOGalleryMsgRevokeMgr)localObject2).jdField_a_of_type_JavaUtilArrayList.iterator();
          while (((Iterator)localObject2).hasNext()) {
            ((MsgRevokeListener)((Iterator)localObject2).next()).a(paramMessageRecord.uniseq);
          }
        }
      }
      ??? = RichmediaService.a();
      if (??? != null)
      {
        localObject2 = new Bundle();
        ((Bundle)localObject2).putLong("msg_revoke_uniseq", paramMessageRecord.uniseq);
        boolean bool = ((RichmediaService)???).a(300, -1, (Bundle)localObject2);
        if (QLog.isColorLevel())
        {
          paramMessageRecord = new StringBuilder();
          paramMessageRecord.append("sendMsgRevokeRequest result:");
          paramMessageRecord.append(bool);
          QLog.i("AIOGalleryMsgRevokeMgr", 0, paramMessageRecord.toString());
        }
      }
    }
  }
  
  public void a(Bundle arg1)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("notifyMsgRevoke, mScene:");
      if (??? != null) {
        localObject1 = ???.toString();
      } else {
        localObject1 = "";
      }
      localStringBuilder.append((String)localObject1);
      QLog.i("AIOGalleryMsgRevokeMgr", 0, localStringBuilder.toString());
    }
    if (??? == null) {
      return;
    }
    long l = ???.getLong("msg_revoke_uniseq", 0L);
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((MsgRevokeListener)((Iterator)localObject1).next()).a(l);
      }
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void a(MsgRevokeListener paramMsgRevokeListener)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramMsgRevokeListener)) {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramMsgRevokeListener);
      }
      return;
    }
  }
  
  public void b(MsgRevokeListener paramMsgRevokeListener)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramMsgRevokeListener);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryMsgRevokeMgr
 * JD-Core Version:    0.7.0.1
 */