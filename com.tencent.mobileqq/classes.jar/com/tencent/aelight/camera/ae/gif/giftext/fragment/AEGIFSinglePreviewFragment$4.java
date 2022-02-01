package com.tencent.aelight.camera.ae.gif.giftext.fragment;

import android.app.Activity;
import com.tencent.aelight.camera.ae.entry.AECameraEntryManager;
import com.tencent.aelight.camera.ae.gif.giftext.AEGIFTextMvp;
import com.tencent.aelight.camera.ae.gif.video.VideoGIFCreator.Callback;
import com.tencent.aelight.camera.aioeditor.takevideo.ShortVideoForwardManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.UiThreadUtil;
import java.util.ArrayList;
import mqq.os.MqqHandler;

class AEGIFSinglePreviewFragment$4
  implements VideoGIFCreator.Callback
{
  AEGIFSinglePreviewFragment$4(AEGIFSinglePreviewFragment paramAEGIFSinglePreviewFragment, boolean paramBoolean) {}
  
  public void a()
  {
    QLog.d("AEGIFSinglePreviewFragment", 4, "onGifCreateFail");
    AEGIFSinglePreviewFragment.a(this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextFragmentAEGIFSinglePreviewFragment);
    UiThreadUtil.a(new AEGIFSinglePreviewFragment.4.2(this));
  }
  
  public void a(String paramString)
  {
    QLog.d("AEGIFSinglePreviewFragment", 4, "onGifCreateSuccess, come from AECAMERA_MODE_ALL");
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    Object localObject1 = AEGIFSinglePreviewFragment.a(this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextFragmentAEGIFSinglePreviewFragment);
    Object localObject2 = "";
    if (localObject1 != null) {
      localObject1 = AEGIFSinglePreviewFragment.a(this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextFragmentAEGIFSinglePreviewFragment).a();
    } else {
      localObject1 = "";
    }
    localArrayList1.add(paramString);
    localArrayList2.add(localObject1);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("gif^");
    if (AEGIFSinglePreviewFragment.a(this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextFragmentAEGIFSinglePreviewFragment) != null) {
      localObject2 = AEGIFSinglePreviewFragment.a(this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextFragmentAEGIFSinglePreviewFragment);
    }
    localStringBuilder.append((String)localObject2);
    localArrayList3.add(localStringBuilder.toString());
    if (this.jdField_a_of_type_Boolean)
    {
      AEGIFSinglePreviewFragment.a(this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextFragmentAEGIFSinglePreviewFragment, localArrayList1, localArrayList2, localArrayList3);
      this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextFragmentAEGIFSinglePreviewFragment.getActivity().setResult(201);
      this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextFragmentAEGIFSinglePreviewFragment.getActivity().finish();
      paramString = this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextFragmentAEGIFSinglePreviewFragment.getActivity().getApplicationContext();
      ThreadManager.getUIHandler().post(new AEGIFSinglePreviewFragment.4.1(this, paramString));
    }
    else
    {
      AEGIFSinglePreviewFragment.a(this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextFragmentAEGIFSinglePreviewFragment, localArrayList1, localArrayList2, localArrayList3);
      if ((AEGIFSinglePreviewFragment.a(this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextFragmentAEGIFSinglePreviewFragment)) && (AEGIFSinglePreviewFragment.a(this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextFragmentAEGIFSinglePreviewFragment) != null))
      {
        localObject2 = this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextFragmentAEGIFSinglePreviewFragment;
        AEGIFSinglePreviewFragment.a((AEGIFSinglePreviewFragment)localObject2, paramString, AEGIFSinglePreviewFragment.a((AEGIFSinglePreviewFragment)localObject2), (String)localObject1, AEGIFSinglePreviewFragment.a(this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextFragmentAEGIFSinglePreviewFragment));
      }
      else
      {
        ShortVideoForwardManager.a(AEGIFSinglePreviewFragment.a(this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextFragmentAEGIFSinglePreviewFragment), paramString, AECameraEntryManager.b(this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextFragmentAEGIFSinglePreviewFragment.getActivity()), true, (String)localObject1, AEGIFSinglePreviewFragment.a(this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextFragmentAEGIFSinglePreviewFragment), 1);
      }
    }
    AEGIFSinglePreviewFragment.a(this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextFragmentAEGIFSinglePreviewFragment);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.giftext.fragment.AEGIFSinglePreviewFragment.4
 * JD-Core Version:    0.7.0.1
 */