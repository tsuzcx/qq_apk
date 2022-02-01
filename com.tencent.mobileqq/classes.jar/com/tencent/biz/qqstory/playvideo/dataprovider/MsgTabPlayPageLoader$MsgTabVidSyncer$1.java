package com.tencent.biz.qqstory.playvideo.dataprovider;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playmode.util.MsgTabVideoData;
import com.tribe.async.reactive.SimpleObserver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class MsgTabPlayPageLoader$MsgTabVidSyncer$1
  extends SimpleObserver<List<MsgTabVideoData>>
{
  MsgTabPlayPageLoader$MsgTabVidSyncer$1(MsgTabPlayPageLoader.MsgTabVidSyncer paramMsgTabVidSyncer, IGroupPageLoader.IVidFullSyncer.CallBack paramCallBack) {}
  
  public void a(List<MsgTabVideoData> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    IDataProvider.GroupInfo localGroupInfo = new IDataProvider.GroupInfo(MsgTabPlayPageLoader.MsgTabVidSyncer.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMsgTabPlayPageLoader$MsgTabVidSyncer));
    localGroupInfo.jdField_a_of_type_JavaUtilList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      MsgTabVideoData localMsgTabVideoData = (MsgTabVideoData)localIterator.next();
      String str = localMsgTabVideoData.jdField_a_of_type_JavaLangString;
      localGroupInfo.jdField_a_of_type_JavaUtilMap.put(localMsgTabVideoData.b, str);
      localGroupInfo.jdField_a_of_type_JavaUtilList.add(localMsgTabVideoData.b);
    }
    paramList = MsgTabPlayPageLoader.a(paramList);
    if ((paramList != null) && (!MsgTabPlayPageLoader.MsgTabVidSyncer.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMsgTabPlayPageLoader$MsgTabVidSyncer).a())) {
      localGroupInfo.jdField_a_of_type_JavaLangString = paramList.b;
    }
    localArrayList.add(localGroupInfo);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIGroupPageLoader$IVidFullSyncer$CallBack.a(localArrayList, MsgTabPlayPageLoader.MsgTabVidSyncer.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMsgTabPlayPageLoader$MsgTabVidSyncer).a() ^ true);
  }
  
  public void onError(@NonNull Error paramError)
  {
    int i;
    if ((paramError instanceof ErrorMessage)) {
      i = ((ErrorMessage)paramError).errorCode;
    } else {
      i = 0;
    }
    paramError = new ArrayList();
    paramError.add(MsgTabPlayPageLoader.MsgTabVidSyncer.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMsgTabPlayPageLoader$MsgTabVidSyncer));
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIGroupPageLoader$IVidFullSyncer$CallBack.a(new ErrorMessage(i, "fail"), paramError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.dataprovider.MsgTabPlayPageLoader.MsgTabVidSyncer.1
 * JD-Core Version:    0.7.0.1
 */