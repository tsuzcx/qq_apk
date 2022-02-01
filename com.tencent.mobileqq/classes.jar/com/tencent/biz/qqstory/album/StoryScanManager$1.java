package com.tencent.biz.qqstory.album;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.album.model.StoryAlbum;
import com.tencent.biz.qqstory.album.segment.ScanInfo;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import com.tribe.async.reactive.SimpleObserver;
import java.util.ArrayList;
import java.util.List;

class StoryScanManager$1
  extends SimpleObserver<List<StoryAlbum>>
{
  StoryScanManager$1(StoryScanManager paramStoryScanManager, ScanInfo paramScanInfo) {}
  
  public void a(List<StoryAlbum> paramList)
  {
    super.onNext(paramList);
    StoryScanManager.a(this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryScanManager, 0);
    Object localObject = new StoryScanManager.ScanResultEvent();
    ((StoryScanManager.ScanResultEvent)localObject).jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = new ErrorMessage();
    ((StoryScanManager.ScanResultEvent)localObject).jdField_a_of_type_JavaUtilList = paramList;
    StoryDispatcher.a().dispatch((Dispatcher.Dispatchable)localObject);
    if (!paramList.isEmpty()) {
      StoryScanManager.a(this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryScanManager, this.jdField_a_of_type_ComTencentBizQqstoryAlbumSegmentScanInfo.a(), this.jdField_a_of_type_ComTencentBizQqstoryAlbumSegmentScanInfo.b());
    }
    long l = System.currentTimeMillis() - StoryScanManager.a(this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryScanManager);
    String str = StoryScanManager.a(paramList);
    if (this.jdField_a_of_type_ComTencentBizQqstoryAlbumSegmentScanInfo.a())
    {
      localObject = "2";
      StoryReportor.a("video_shoot_slides", "scan", 0, 0, new String[] { "", localObject, l + "" });
      if (!this.jdField_a_of_type_ComTencentBizQqstoryAlbumSegmentScanInfo.a()) {
        break label271;
      }
    }
    label271:
    for (localObject = "2";; localObject = "1")
    {
      StoryReportor.a("video_shoot_slides", "piece_smartalbum", 0, 0, new String[] { str, localObject, paramList.size() + "" });
      SLog.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "scan and split success timecost=%s : ScanInfo =%s result=%s", new Object[] { Long.valueOf(l), this.jdField_a_of_type_ComTencentBizQqstoryAlbumSegmentScanInfo, str });
      StoryScanManager.a(this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryScanManager, this.jdField_a_of_type_ComTencentBizQqstoryAlbumSegmentScanInfo);
      return;
      localObject = "1";
      break;
    }
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    Object localObject = new StoryScanManager.ScanResultEvent();
    ((StoryScanManager.ScanResultEvent)localObject).jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = ((ErrorMessage)paramError);
    ((StoryScanManager.ScanResultEvent)localObject).jdField_a_of_type_JavaUtilList = new ArrayList();
    StoryDispatcher.a().dispatch((Dispatcher.Dispatchable)localObject);
    StoryScanManager.a(this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryScanManager, 0);
    SLog.e("Q.qqstory.recommendAlbum.logic.StoryScanManager", "scan and split falied : " + paramError);
    long l1 = System.currentTimeMillis();
    long l2 = StoryScanManager.a(this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryScanManager);
    int i = ((ErrorMessage)paramError).errorCode;
    localObject = ((ErrorMessage)paramError).errorMsg;
    if (this.jdField_a_of_type_ComTencentBizQqstoryAlbumSegmentScanInfo.a()) {}
    for (paramError = "2";; paramError = "1")
    {
      StoryReportor.a("video_shoot_slides", "scan", 0, i, new String[] { localObject, paramError, l1 - l2 + "" });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.StoryScanManager.1
 * JD-Core Version:    0.7.0.1
 */