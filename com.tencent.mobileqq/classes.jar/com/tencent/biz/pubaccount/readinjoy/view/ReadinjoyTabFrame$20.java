package com.tencent.biz.pubaccount.readinjoy.view;

import bdhj;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ZImageView;
import java.net.MalformedURLException;
import java.net.URL;

class ReadinjoyTabFrame$20
  implements Runnable
{
  public void run()
  {
    try
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.setRound(true);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.a(bdhj.a()).a(new URL(ReadInJoyUserInfoModule.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadInJoyUserInfo)));
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      localMalformedURLException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame.20
 * JD-Core Version:    0.7.0.1
 */