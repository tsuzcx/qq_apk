package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.qphone.base.util.QLog;
import spu;
import sxc;

public class VideoPreDownloadMgr$3$1
  implements Runnable
{
  public VideoPreDownloadMgr$3$1(spu paramspu, sxc paramsxc) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Sxc.b.equals(VideoPreDownloadMgr.a(this.jdField_a_of_type_Spu.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr)))
    {
      if (this.jdField_a_of_type_Spu.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(this.jdField_a_of_type_Sxc.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Sxc.b))
      {
        if (QLog.isColorLevel()) {
          QLog.i(VideoPreDownloadMgr.a(), 2, "innerDoPreDownload() 缓冲已存在，跳过, vid=" + this.jdField_a_of_type_Sxc.b);
        }
        VideoPreDownloadMgr.a(this.jdField_a_of_type_Spu.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr, null);
        VideoPreDownloadMgr.b(this.jdField_a_of_type_Spu.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr);
      }
    }
    else {
      return;
    }
    VideoPreDownloadMgr.a(this.jdField_a_of_type_Spu.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr, this.jdField_a_of_type_Sxc.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Sxc.b, this.jdField_a_of_type_Sxc.jdField_a_of_type_Int, this.jdField_a_of_type_Spu.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr.3.1
 * JD-Core Version:    0.7.0.1
 */