package com.tencent.biz.qqstory.msgTabNode.view;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;
import com.tencent.biz.qqstory.playmode.util.MsgTabVideoData;
import com.tencent.biz.qqstory.playvideo.StoryPlayerLauncher;
import com.tencent.biz.qqstory.playvideo.dataprovider.MsgTabPlayInfo;
import com.tencent.biz.qqstory.playvideo.dataprovider.MsgTabPlayPageLoader;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.Data;
import com.tribe.async.reactive.SimpleObserver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class MsgTabStoryNodeListManager$9
  extends SimpleObserver<List<MsgTabVideoData>>
{
  MsgTabStoryNodeListManager$9(MsgTabStoryNodeListManager paramMsgTabStoryNodeListManager, MsgTabNodeInfo paramMsgTabNodeInfo, View paramView, Activity paramActivity) {}
  
  private void a(String paramString1, String paramString2, ArrayList<String> paramArrayList, HashMap<String, String> paramHashMap)
  {
    String str = paramString1;
    if (!TextUtils.isEmpty(paramString2))
    {
      str = paramString1;
      if (TextUtils.isEmpty(paramString1)) {
        str = "NO_SUCH_FEED_ID";
      }
    }
    paramString1 = new OpenPlayerBuilder(new MsgTabPlayInfo(this.a.d, 0, null, str, paramString2, paramArrayList, paramHashMap), 106);
    paramString1.a(this.d.n());
    paramString1 = paramString1.f();
    paramString1.mUIStyle.bottomWidgetShowFlag = 3;
    paramString2 = this.b;
    if ((paramString2 instanceof StoryMsgNodeFrameLayout))
    {
      StoryPlayerLauncher.a(this.c, paramString1, ((StoryMsgNodeFrameLayout)paramString2).a);
      return;
    }
    StoryPlayerLauncher.a(this.c, paramString1, paramString2);
  }
  
  public void a(List<MsgTabVideoData> paramList)
  {
    Object localObject = MsgTabPlayPageLoader.b(paramList);
    String str1 = null;
    if (localObject != null)
    {
      str1 = ((MsgTabVideoData)localObject).b;
      localObject = ((MsgTabVideoData)localObject).c;
    }
    else
    {
      localObject = null;
    }
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap = new HashMap();
    int i = 0;
    while (i < paramList.size())
    {
      String str2 = ((MsgTabVideoData)paramList.get(i)).c;
      if (TextUtils.isEmpty(str2)) {
        break;
      }
      localArrayList.add(str2);
      localHashMap.put(str2, ((MsgTabVideoData)paramList.get(i)).b);
      i += 1;
    }
    a(str1, (String)localObject, localArrayList, localHashMap);
  }
  
  public void onError(@NonNull Error paramError)
  {
    a("", "", null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeListManager.9
 * JD-Core Version:    0.7.0.1
 */