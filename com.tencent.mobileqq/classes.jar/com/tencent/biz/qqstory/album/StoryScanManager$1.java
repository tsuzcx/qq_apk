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
  public void a(List<StoryAlbum> paramList)
  {
    super.onNext(paramList);
    StoryScanManager.a(this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryScanManager, 0);
    Object localObject1 = new StoryScanManager.ScanResultEvent();
    ((StoryScanManager.ScanResultEvent)localObject1).jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = new ErrorMessage();
    ((StoryScanManager.ScanResultEvent)localObject1).jdField_a_of_type_JavaUtilList = paramList;
    StoryDispatcher.a().dispatch((Dispatcher.Dispatchable)localObject1);
    if (!paramList.isEmpty()) {
      StoryScanManager.a(this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryScanManager, this.jdField_a_of_type_ComTencentBizQqstoryAlbumSegmentScanInfo.a(), this.jdField_a_of_type_ComTencentBizQqstoryAlbumSegmentScanInfo.b());
    }
    long l = System.currentTimeMillis() - StoryScanManager.a(this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryScanManager);
    String str = StoryScanManager.a(paramList);
    boolean bool = this.jdField_a_of_type_ComTencentBizQqstoryAlbumSegmentScanInfo.a();
    Object localObject2 = "2";
    if (bool) {
      localObject1 = "2";
    } else {
      localObject1 = "1";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(l);
    localStringBuilder.append("");
    StoryReportor.a("video_shoot_slides", "scan", 0, 0, new String[] { "", localObject1, localStringBuilder.toString() });
    if (this.jdField_a_of_type_ComTencentBizQqstoryAlbumSegmentScanInfo.a()) {
      localObject1 = localObject2;
    } else {
      localObject1 = "1";
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramList.size());
    ((StringBuilder)localObject2).append("");
    StoryReportor.a("video_shoot_slides", "piece_smartalbum", 0, 0, new String[] { str, localObject1, ((StringBuilder)localObject2).toString() });
    SLog.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "scan and split success timecost=%s : ScanInfo =%s result=%s", new Object[] { Long.valueOf(l), this.jdField_a_of_type_ComTencentBizQqstoryAlbumSegmentScanInfo, str });
    StoryScanManager.a(this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryScanManager, this.jdField_a_of_type_ComTencentBizQqstoryAlbumSegmentScanInfo);
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    Object localObject2 = new StoryScanManager.ScanResultEvent();
    Object localObject1 = (ErrorMessage)paramError;
    ((StoryScanManager.ScanResultEvent)localObject2).jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = ((ErrorMessage)localObject1);
    ((StoryScanManager.ScanResultEvent)localObject2).jdField_a_of_type_JavaUtilList = new ArrayList();
    StoryDispatcher.a().dispatch((Dispatcher.Dispatchable)localObject2);
    StoryScanManager.a(this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryScanManager, 0);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("scan and split falied : ");
    ((StringBuilder)localObject2).append(paramError);
    SLog.e("Q.qqstory.recommendAlbum.logic.StoryScanManager", ((StringBuilder)localObject2).toString());
    long l1 = System.currentTimeMillis();
    long l2 = StoryScanManager.a(this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryScanManager);
    int i = ((ErrorMessage)localObject1).errorCode;
    localObject1 = ((ErrorMessage)localObject1).errorMsg;
    if (this.jdField_a_of_type_ComTencentBizQqstoryAlbumSegmentScanInfo.a()) {
      paramError = "2";
    } else {
      paramError = "1";
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(l1 - l2);
    ((StringBuilder)localObject2).append("");
    StoryReportor.a("video_shoot_slides", "scan", 0, i, new String[] { localObject1, paramError, ((StringBuilder)localObject2).toString() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.StoryScanManager.1
 * JD-Core Version:    0.7.0.1
 */