package com.tencent.aelight.camera.ae.album.logic;

import android.content.Intent;
import com.tencent.aelight.camera.ae.album.fragment.AENewPhotoListFragment;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.album.PhotoListData;
import java.util.ArrayList;
import mqq.util.WeakReference;

class AEPhotoListLogicDefault$2
  implements Runnable
{
  AEPhotoListLogicDefault$2(AEPhotoListLogicDefault paramAEPhotoListLogicDefault, Intent paramIntent, ArrayList paramArrayList) {}
  
  public void run()
  {
    PhotoUtils.sendPhoto(((AENewPhotoListFragment)this.this$0.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), this.jdField_a_of_type_AndroidContentIntent, this.jdField_a_of_type_JavaUtilArrayList, 2, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.a);
    com.tencent.mobileqq.shortvideo.SVBusiUtil.b = System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.album.logic.AEPhotoListLogicDefault.2
 * JD-Core Version:    0.7.0.1
 */