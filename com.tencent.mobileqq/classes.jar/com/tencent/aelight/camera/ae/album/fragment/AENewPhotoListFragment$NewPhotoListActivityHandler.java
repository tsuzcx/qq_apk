package com.tencent.aelight.camera.ae.album.fragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.aelight.camera.ae.album.logic.AEPhotoListLogic;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

class AENewPhotoListFragment$NewPhotoListActivityHandler
  extends Handler
{
  private final WeakReference<AENewPhotoListFragment> a;
  
  public AENewPhotoListFragment$NewPhotoListActivityHandler(AENewPhotoListFragment paramAENewPhotoListFragment)
  {
    this.a = new WeakReference(paramAENewPhotoListFragment);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      if (((WeakReference)localObject).get() == null) {
        return;
      }
      localObject = (AENewPhotoListFragment)this.a.get();
      int i = paramMessage.what;
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2) {
            return;
          }
          ((AENewPhotoListFragment)localObject).h();
          QLog.e("PhotoListActivity", 2, new Object[] { "onEncodeError = ", Integer.valueOf(((Integer)paramMessage.obj).intValue()) });
          QQToast.a(((AENewPhotoListFragment)localObject).getActivity(), ((AENewPhotoListFragment)localObject).getResources().getString(2131694860), 0).a();
          return;
        }
        ((AENewPhotoListFragment)this.a.get()).jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogic.a(paramMessage);
        return;
      }
      localObject = ((AENewPhotoListFragment)localObject).jdField_a_of_type_ComTencentAelightCameraAeAlbumFragmentAEAbstractPhotoListFragment$PhotoGridAdapter;
      if (localObject == null) {
        return;
      }
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(((AEAbstractPhotoListFragment.PhotoGridAdapter)localObject).a);
      paramMessage = paramMessage.getData();
      i = paramMessage.getInt("ALBUMLIST_POSITION");
      long l = paramMessage.getLong("ALBUMLIST_ITEM_DURATION");
      paramMessage = (LocalMediaInfo)localArrayList.get(i);
      paramMessage.mDuration = l;
      localArrayList.set(i, paramMessage);
      ((AEAbstractPhotoListFragment.PhotoGridAdapter)localObject).a(localArrayList, true);
      ((AEAbstractPhotoListFragment.PhotoGridAdapter)localObject).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.album.fragment.AENewPhotoListFragment.NewPhotoListActivityHandler
 * JD-Core Version:    0.7.0.1
 */