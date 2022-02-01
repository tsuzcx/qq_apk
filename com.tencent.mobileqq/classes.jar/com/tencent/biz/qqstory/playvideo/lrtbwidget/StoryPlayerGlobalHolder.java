package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.dataprovider.IDataProvider.Data;
import com.tencent.biz.qqstory.playvideo.dataprovider.IDataProvider.GroupId;
import com.tencent.biz.qqstory.playvideo.dataprovider.IDataProvider.GroupInfo;
import com.tencent.biz.qqstory.playvideo.playerwidget.ProgressBarVideoInfoWidget;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.qqperf.monitor.crash.catchedexception.CaughtExceptionReport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class StoryPlayerGlobalHolder
  extends StoryPlayerContextWrapper
{
  @NonNull
  public final View a;
  private IDataProvider.GroupId jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId;
  private OnSuperPageChangeListener jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetOnSuperPageChangeListener;
  @NonNull
  final PromoteWidgetController jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetPromoteWidgetController;
  private final StoryPlayerGlobalHolder.GroupOnPageChangeListener jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGlobalHolder$GroupOnPageChangeListener;
  private final StoryPlayerGlobalHolder.VideoOnPageChangeListener jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGlobalHolder$VideoOnPageChangeListener;
  @NonNull
  private final StoryPlayerGroupAdapter jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter;
  private UIGroupInfo jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetUIGroupInfo;
  private VideoHolderBase jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoHolderBase;
  private final VideoViewVideoHolder.VideoViewListener jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder$VideoViewListener;
  @NonNull
  public final XViewPager a;
  private List<IDataProvider.GroupInfo> jdField_a_of_type_JavaUtilList = new LinkedList();
  private Map<String, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  private UIGroupInfo b;
  
  public StoryPlayerGlobalHolder(@NonNull ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131380822);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager = ((XViewPager)this.jdField_a_of_type_AndroidViewView);
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager;
    ((XViewPager)localObject).jdField_a_of_type_JavaLangString = "XViewPager_Vertical";
    ((XViewPager)localObject).setEnableScrollDirection(false, false, true, true);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetPromoteWidgetController = new PromoteWidgetController();
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setOverScrollMode(2);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setEnableOverScroll(true);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setPageTransformer(true, new PageTransformerWrapper(new ThreeDTransformer(true, true)));
    int i = (int)paramViewGroup.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setPageTurningThreshold(0.4F);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setDistanceAndVelocityThreshold(i * 10, i * 80);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter = new StoryPlayerGroupAdapter(this);
    paramViewGroup = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter;
    localObject = new StoryPlayerGlobalHolder.VideoOnPageChangeListener(this, null);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGlobalHolder$VideoOnPageChangeListener = ((StoryPlayerGlobalHolder.VideoOnPageChangeListener)localObject);
    StoryPlayerGlobalHolder.VideoViewListener localVideoViewListener = new StoryPlayerGlobalHolder.VideoViewListener(this, null);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder$VideoViewListener = localVideoViewListener;
    paramViewGroup.a((OnSuperPageChangeListener)localObject, localVideoViewListener);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setPageMargin(10);
    paramViewGroup = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager;
    localObject = new StoryPlayerGlobalHolder.GroupOnPageChangeListener(this, null);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGlobalHolder$GroupOnPageChangeListener = ((StoryPlayerGlobalHolder.GroupOnPageChangeListener)localObject);
    paramViewGroup.setOnPageChangeListener((XViewPager.OnPageChangeListener)localObject);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setAdapter(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter);
    new Handler(Looper.getMainLooper()).post(new StoryPlayerGlobalHolder.1(this));
  }
  
  private void a(@NonNull String paramString, @NonNull List<IDataProvider.GroupInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = paramList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      IDataProvider.GroupInfo localGroupInfo = (IDataProvider.GroupInfo)((Iterator)localObject).next();
      StringBuilder localStringBuilder;
      if (localGroupInfo.c())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(localGroupInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.jdField_a_of_type_JavaLangString);
        localStringBuilder.append("(Loading)");
        localArrayList.add(localStringBuilder.toString());
      }
      else if (localGroupInfo.b())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(localGroupInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.jdField_a_of_type_JavaLangString);
        localStringBuilder.append("(Error)");
        localArrayList.add(localStringBuilder.toString());
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(localGroupInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.jdField_a_of_type_JavaLangString);
        localStringBuilder.append("(");
        localStringBuilder.append(localGroupInfo.jdField_a_of_type_JavaUtilList.size());
        localStringBuilder.append(")");
        localArrayList.add(localStringBuilder.toString());
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(", size=%d, list=%s");
    SLog.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", ((StringBuilder)localObject).toString(), Integer.valueOf(paramList.size()), localArrayList);
  }
  
  public IDataProvider.GroupId a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId;
  }
  
  @Nullable
  public StoryPlayerGroupHolder a(int paramInt)
  {
    XViewPager.ItemInfo localItemInfo = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.a(paramInt);
    if (localItemInfo != null) {
      return (StoryPlayerGroupHolder)localItemInfo.a;
    }
    return null;
  }
  
  public String a(String paramString)
  {
    return (String)this.jdField_a_of_type_JavaUtilMap.get(paramString);
  }
  
  public List<IDataProvider.GroupInfo> a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter.a();
  }
  
  public void a(IDataProvider.Data paramData, IDataProvider.GroupId paramGroupId)
  {
    SLog.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, up-end=%s, down-end=%s, up-error=%s, down-error=%s, data-size=%d, selectedGroupId=%s", new Object[] { Boolean.valueOf(paramData.jdField_a_of_type_Boolean), Boolean.valueOf(paramData.jdField_b_of_type_Boolean), paramData.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage, paramData.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage, Integer.valueOf(paramData.jdField_a_of_type_JavaUtilList.size()), paramGroupId.jdField_a_of_type_JavaLangString });
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId = paramGroupId;
    ArrayList localArrayList = new ArrayList(paramData.jdField_a_of_type_JavaUtilList);
    a("onBind, newGroupInfoList", localArrayList);
    if (localArrayList.size() == 0) {
      return;
    }
    Object localObject = localArrayList.iterator();
    IDataProvider.GroupInfo localGroupInfo;
    while (((Iterator)localObject).hasNext())
    {
      localGroupInfo = (IDataProvider.GroupInfo)((Iterator)localObject).next();
      String str = (String)this.jdField_a_of_type_JavaUtilMap.get(localGroupInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.jdField_a_of_type_JavaLangString);
      if ((!TextUtils.isEmpty(str)) && (!str.startsWith("LoadingGroup")) && (!str.startsWith("ErrorGroup")))
      {
        if ((!TextUtils.isEmpty(str)) && (!localGroupInfo.jdField_a_of_type_JavaUtilList.contains(str)))
        {
          SLog.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, mark position, groupId=%s, CURRENT ! old=%s", localGroupInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.jdField_a_of_type_JavaLangString, str);
          this.jdField_a_of_type_JavaUtilMap.put(localGroupInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.jdField_a_of_type_JavaLangString, null);
        }
      }
      else if (!TextUtils.isEmpty(localGroupInfo.jdField_a_of_type_JavaLangString))
      {
        SLog.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, mark position, groupId=%s, firstPlayVid=%s", localGroupInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.jdField_a_of_type_JavaLangString, localGroupInfo.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_JavaUtilMap.put(localGroupInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.jdField_a_of_type_JavaLangString, localGroupInfo.jdField_a_of_type_JavaLangString);
      }
      else if (localGroupInfo.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        SLog.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, mark position, groupId=%s, first - vid=%s", localGroupInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.jdField_a_of_type_JavaLangString, localGroupInfo.jdField_a_of_type_JavaUtilList.get(0));
        this.jdField_a_of_type_JavaUtilMap.put(localGroupInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.jdField_a_of_type_JavaLangString, localGroupInfo.jdField_a_of_type_JavaUtilList.get(0));
      }
      else
      {
        SLog.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, mark position, groupId=%s, vid=%s", localGroupInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.jdField_a_of_type_JavaLangString, null);
        this.jdField_a_of_type_JavaUtilMap.put(localGroupInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.jdField_a_of_type_JavaLangString, null);
      }
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetPromoteWidgetController.a(paramData, paramGroupId.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_JavaUtilList.isEmpty()) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramData.jdField_a_of_type_JavaUtilList);
    }
    int i;
    int j;
    int k;
    for (;;)
    {
      i = 1;
      j = 1;
      k = 1;
      break label1450;
      localObject = (IDataProvider.GroupInfo)localArrayList.get(0);
      int i4 = this.jdField_a_of_type_JavaUtilList.indexOf(localObject);
      localObject = (IDataProvider.GroupInfo)localArrayList.get(localArrayList.size() - 1);
      int i5 = this.jdField_a_of_type_JavaUtilList.indexOf(localObject);
      SLog.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, firstPosition=%d, lastPosition=%d", Integer.valueOf(i4), Integer.valueOf(i5));
      if (i4 != -1)
      {
        n = i4;
        m = 0;
        j = 0;
        k = 0;
        i = 0;
        while (m < localArrayList.size())
        {
          if (n < this.jdField_a_of_type_JavaUtilList.size()) {
            localObject = (IDataProvider.GroupInfo)this.jdField_a_of_type_JavaUtilList.get(n);
          } else {
            localObject = null;
          }
          localGroupInfo = (IDataProvider.GroupInfo)localArrayList.get(m);
          if (localGroupInfo != null)
          {
            if (n == 0) {
              j = 1;
            }
            if (n == this.jdField_a_of_type_JavaUtilList.size() - 1) {
              k = 1;
            }
            if (localObject != null)
            {
              if ((((IDataProvider.GroupInfo)localObject).equals(localGroupInfo)) && (((IDataProvider.GroupInfo)localObject).b() == localGroupInfo.b()) && (((IDataProvider.GroupInfo)localObject).c() == localGroupInfo.c()))
              {
                if (((IDataProvider.GroupInfo)localObject).jdField_a_of_type_JavaUtilList.size() != localGroupInfo.jdField_a_of_type_JavaUtilList.size())
                {
                  SLog.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, --, the group info update !! groupId=%s, old vid list = %s, new vid list = %s", ((IDataProvider.GroupInfo)localObject).jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId, ((IDataProvider.GroupInfo)localObject).jdField_a_of_type_JavaUtilList, localGroupInfo.jdField_a_of_type_JavaUtilList);
                  this.jdField_a_of_type_JavaUtilList.set(n, localGroupInfo);
                }
                else
                {
                  i1 = 0;
                  while (i1 < ((IDataProvider.GroupInfo)localObject).jdField_a_of_type_JavaUtilList.size())
                  {
                    if (!TextUtils.equals((CharSequence)((IDataProvider.GroupInfo)localObject).jdField_a_of_type_JavaUtilList.get(i1), (CharSequence)localGroupInfo.jdField_a_of_type_JavaUtilList.get(i1)))
                    {
                      i1 = 0;
                      break label832;
                    }
                    i1 += 1;
                  }
                  i1 = 1;
                  label832:
                  if (i1 == 0)
                  {
                    SLog.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, --, the group info update, vid list size equal !! groupId=%s, old vid list = %s, new vid list = %s", new Object[] { ((IDataProvider.GroupInfo)localObject).jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId, ((IDataProvider.GroupInfo)localObject).jdField_a_of_type_JavaUtilList, localGroupInfo.jdField_a_of_type_JavaUtilList });
                    this.jdField_a_of_type_JavaUtilList.set(n, localGroupInfo);
                    i = 1;
                  }
                  break label968;
                }
              }
              else
              {
                SLog.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, --, the group info replace !! old = %s, new = %s", new Object[] { ((IDataProvider.GroupInfo)localObject).jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId, localGroupInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId });
                this.jdField_a_of_type_JavaUtilList.set(n, localGroupInfo);
              }
            }
            else
            {
              SLog.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, --, new group info = %s", localGroupInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId);
              this.jdField_a_of_type_JavaUtilList.add(n, localGroupInfo);
            }
            i = 1;
            label968:
            n += 1;
            m += 1;
          }
          else
          {
            SLog.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, --, new group info is null !!");
          }
        }
      }
      else
      {
        j = 0;
        k = 0;
        i = 0;
      }
      int i1 = j;
      int m = k;
      int n = i;
      if (i4 == -1)
      {
        i1 = j;
        m = k;
        n = i;
        if (i5 != -1)
        {
          int i2 = localArrayList.size() - 1;
          int i3 = i5;
          for (;;)
          {
            i1 = j;
            m = k;
            n = i;
            if (i2 < 0) {
              break label1352;
            }
            if (i3 >= 0) {
              localObject = (IDataProvider.GroupInfo)this.jdField_a_of_type_JavaUtilList.get(i3);
            } else {
              localObject = null;
            }
            localGroupInfo = (IDataProvider.GroupInfo)localArrayList.get(i2);
            if (localGroupInfo == null) {
              break;
            }
            if (i3 == 0) {
              j = 1;
            }
            if (i3 == this.jdField_a_of_type_JavaUtilList.size() - 1) {
              k = 1;
            }
            if (localObject != null)
            {
              if ((((IDataProvider.GroupInfo)localObject).equals(localGroupInfo)) && (((IDataProvider.GroupInfo)localObject).b() == localGroupInfo.b()) && (((IDataProvider.GroupInfo)localObject).c() == localGroupInfo.c()))
              {
                if (((IDataProvider.GroupInfo)localObject).jdField_a_of_type_JavaUtilList.size() != localGroupInfo.jdField_a_of_type_JavaUtilList.size())
                {
                  SLog.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, top, the group info update !! groupId=%s, old vid list = %s, new vid list = %s", ((IDataProvider.GroupInfo)localObject).jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId, ((IDataProvider.GroupInfo)localObject).jdField_a_of_type_JavaUtilList, localGroupInfo.jdField_a_of_type_JavaUtilList);
                  this.jdField_a_of_type_JavaUtilList.set(i3, localGroupInfo);
                }
                else
                {
                  break label1318;
                }
              }
              else
              {
                SLog.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, top, the group info replace !! old = %s, new = %s", new Object[] { ((IDataProvider.GroupInfo)localObject).jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId, localGroupInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId });
                this.jdField_a_of_type_JavaUtilList.set(i3, localGroupInfo);
              }
            }
            else
            {
              SLog.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, top, new group info = %s", localGroupInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId);
              this.jdField_a_of_type_JavaUtilList.add(0, localGroupInfo);
            }
            i = 1;
            label1318:
            i3 -= 1;
            i2 -= 1;
          }
          SLog.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, top, new group info is null !!");
          n = i;
          m = k;
          i1 = j;
        }
      }
      label1352:
      i = i1;
      j = m;
      k = n;
      if (i4 != -1) {
        break label1450;
      }
      i = i1;
      j = m;
      k = n;
      if (i5 != -1) {
        break label1450;
      }
      if (localArrayList.indexOf(this.jdField_a_of_type_JavaUtilList.get(0)) == -1) {
        break;
      }
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll(paramData.jdField_a_of_type_JavaUtilList);
    }
    SLog.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, data conflict. ignore update !");
    CaughtExceptionReport.a(new Throwable());
    return;
    label1450:
    a("onBind, currentGroupInfoList", this.jdField_a_of_type_JavaUtilList);
    localArrayList.clear();
    localArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
    if (i != 0)
    {
      SLog.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "firstGroupInfo = %s", new Object[] { (IDataProvider.GroupInfo)localArrayList.get(0) });
      if (!paramData.jdField_a_of_type_Boolean)
      {
        if ((paramData.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage != null) && (!paramData.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()))
        {
          localObject = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetUIGroupInfo;
          if ((localObject != null) && (((UIGroupInfo)localObject).b())) {
            i = 0;
          } else {
            i = 1;
          }
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetUIGroupInfo = new UIGroupInfo(new ErrorMessage(paramData.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage), true);
          localArrayList.add(0, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetUIGroupInfo);
        }
        else
        {
          localObject = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetUIGroupInfo;
          if ((localObject != null) && (((UIGroupInfo)localObject).c())) {
            i = 0;
          } else {
            i = 1;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("top_");
          ((StringBuilder)localObject).append(SystemClock.uptimeMillis());
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetUIGroupInfo = new UIGroupInfo(((StringBuilder)localObject).toString(), true);
          localArrayList.add(0, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetUIGroupInfo);
        }
      }
      else if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetUIGroupInfo != null)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetUIGroupInfo = null;
        i = 1;
      }
      else
      {
        i = 0;
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetUIGroupInfo;
      if (localObject != null) {
        localArrayList.add(0, localObject);
      }
      i = 0;
    }
    if (j != 0)
    {
      SLog.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "lastGroupInfo = %s", new Object[] { (IDataProvider.GroupInfo)localArrayList.get(localArrayList.size() - 1) });
      if (!paramData.jdField_b_of_type_Boolean)
      {
        if ((paramData.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage != null) && (!paramData.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()))
        {
          localObject = this.b;
          if ((localObject == null) || (!((UIGroupInfo)localObject).b())) {
            i = 1;
          }
          this.b = new UIGroupInfo(new ErrorMessage(paramData.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage), false);
          localArrayList.add(this.b);
          j = i;
        }
        else
        {
          paramData = this.b;
          if ((paramData == null) || (!paramData.c())) {
            i = 1;
          }
          paramData = new StringBuilder();
          paramData.append("bottom_");
          paramData.append(SystemClock.uptimeMillis());
          this.b = new UIGroupInfo(paramData.toString(), false);
          localArrayList.add(this.b);
          j = i;
        }
      }
      else
      {
        j = i;
        if (this.b != null)
        {
          this.b = null;
          j = 1;
        }
      }
    }
    else
    {
      paramData = this.b;
      j = i;
      if (paramData != null)
      {
        localArrayList.add(paramData);
        j = i;
      }
    }
    a("onBind, allGroupInfoList", localArrayList);
    if ((j == 0) && (k == 0))
    {
      SLog.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, ignore because nothing changed");
      return;
    }
    SLog.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, update adapter because changed");
    if (localArrayList.size() > 0)
    {
      i = 0;
      while (i < localArrayList.size())
      {
        if (TextUtils.equals(((IDataProvider.GroupInfo)localArrayList.get(i)).jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.jdField_a_of_type_JavaLangString, paramGroupId.jdField_a_of_type_JavaLangString)) {
          break label2056;
        }
        i += 1;
      }
      i = -1;
      label2056:
      SLog.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, currentVerticalPosition=%d, selectedGroupId=%s", Integer.valueOf(i), paramGroupId.jdField_a_of_type_JavaLangString);
      if (i != -1)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter.a(localArrayList);
        SLog.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, setCurrentItem after setDataList, position=%d", new Object[] { Integer.valueOf(i) });
        if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c() == i)
        {
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGlobalHolder$GroupOnPageChangeListener.a(i);
          return;
        }
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setCurrentItem(i, false);
        return;
      }
      SLog.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, data update ignore !!");
    }
  }
  
  public void a(IDataProvider.GroupId paramGroupId, String paramString, boolean paramBoolean)
  {
    int j = 0;
    int k = 0;
    if ((paramGroupId != null) && (paramString != null))
    {
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        if (((IDataProvider.GroupInfo)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.equals(paramGroupId)) {
          break label73;
        }
        i += 1;
      }
      i = -1;
      label73:
      if (i < 0)
      {
        SLog.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onGroupDataDelete, can not find the group which is deleted ! delete group = %s, vid = %s, isGroupDeleted = %s", new Object[] { paramGroupId.jdField_a_of_type_JavaLangString, paramString, Boolean.valueOf(paramBoolean) });
        return;
      }
      ArrayList localArrayList = null;
      paramGroupId = null;
      if (paramBoolean)
      {
        if (i < this.jdField_a_of_type_JavaUtilList.size() - 1) {
          paramGroupId = (IDataProvider.GroupInfo)this.jdField_a_of_type_JavaUtilList.get(i + 1);
        }
        this.jdField_a_of_type_JavaUtilList.remove(i);
        localObject = new ArrayList(this.jdField_a_of_type_JavaUtilList);
        paramString = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetUIGroupInfo;
        if (paramString != null) {
          ((ArrayList)localObject).add(0, paramString);
        }
        paramString = this.b;
        if (paramString != null) {
          ((ArrayList)localObject).add(paramString);
        }
        paramString = paramGroupId;
        if (paramGroupId == null) {
          paramString = this.b;
        }
        if (paramString == null)
        {
          SLog.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onGroupDataDelete, delete one group and then no any more group, exit");
          a().finish();
          return;
        }
        SLog.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onGroupDataDelete, delete one group and then play next group, nextGroup = %s", new Object[] { paramString.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.jdField_a_of_type_JavaLangString });
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId = paramString.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId;
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter.a((ArrayList)localObject);
        i = k;
        while (i < ((ArrayList)localObject).size())
        {
          if (TextUtils.equals(((IDataProvider.GroupInfo)((ArrayList)localObject).get(i)).jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.jdField_a_of_type_JavaLangString, paramString.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.jdField_a_of_type_JavaLangString)) {
            break label336;
          }
          i += 1;
        }
        i = -1;
        label336:
        if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c() == i)
        {
          SLog.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onGroupDataDelete, fake onPageSelected, position = %d", Integer.valueOf(i));
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGlobalHolder$GroupOnPageChangeListener.a(i);
          return;
        }
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setCurrentItem(i, true);
        return;
      }
      Object localObject = (IDataProvider.GroupInfo)this.jdField_a_of_type_JavaUtilList.get(i);
      k = ((IDataProvider.GroupInfo)localObject).jdField_a_of_type_JavaUtilList.indexOf(paramString);
      if (k < 0)
      {
        SLog.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "deletedVid=%s, vidList=%s", new Object[] { paramString, ((IDataProvider.GroupInfo)localObject).jdField_a_of_type_JavaUtilList });
        AssertUtils.assertTrue(false, "找不到被删除的vid");
        return;
      }
      if (k < ((IDataProvider.GroupInfo)localObject).jdField_a_of_type_JavaUtilList.size() - 1)
      {
        paramString = (String)((IDataProvider.GroupInfo)localObject).jdField_a_of_type_JavaUtilList.get(k + 1);
        paramGroupId = (IDataProvider.GroupId)localObject;
      }
      else if (i < this.jdField_a_of_type_JavaUtilList.size() - 1)
      {
        paramGroupId = (IDataProvider.GroupInfo)this.jdField_a_of_type_JavaUtilList.get(i + 1);
        paramString = localArrayList;
      }
      else
      {
        paramGroupId = null;
        paramString = localArrayList;
      }
      ((IDataProvider.GroupInfo)localObject).jdField_a_of_type_JavaUtilList.remove(k);
      localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilList);
      localObject = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetUIGroupInfo;
      if (localObject != null) {
        localArrayList.add(0, localObject);
      }
      localObject = this.b;
      if (localObject != null) {
        localArrayList.add(localObject);
      }
      localObject = paramGroupId;
      if (paramGroupId == null) {
        localObject = this.b;
      }
      if (localObject == null)
      {
        SLog.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "delete one vid and then no any more group, exit");
        a().finish();
        return;
      }
      if (paramString != null) {
        paramGroupId = "vid";
      } else {
        paramGroupId = "group";
      }
      SLog.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "delete one vid and then play next %s, nextGroup = %s, nextVid = %s", new Object[] { paramGroupId, ((IDataProvider.GroupInfo)localObject).jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.jdField_a_of_type_JavaLangString, paramString });
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId = ((IDataProvider.GroupInfo)localObject).jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId;
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter.a(localArrayList);
      if (paramString == null)
      {
        i = j;
        while (i < localArrayList.size())
        {
          if (TextUtils.equals(((IDataProvider.GroupInfo)localArrayList.get(i)).jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.jdField_a_of_type_JavaLangString, ((IDataProvider.GroupInfo)localObject).jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.jdField_a_of_type_JavaLangString)) {
            break label758;
          }
          i += 1;
        }
        i = -1;
        label758:
        if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c() == i)
        {
          SLog.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onGroupDataDelete, fake onPageSelected, position = %d", Integer.valueOf(i));
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGlobalHolder$GroupOnPageChangeListener.a(i);
          return;
        }
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setCurrentItem(i, true);
      }
      return;
    }
    SLog.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onGroupDataDelete, deleteGroupId=%s, deleteVid=%s", new Object[] { paramGroupId, paramString });
  }
  
  public void a(OnSuperPageChangeListener paramOnSuperPageChangeListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetOnSuperPageChangeListener = paramOnSuperPageChangeListener;
  }
  
  public boolean a(@Nullable VideoHolderBase paramVideoHolderBase)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGlobalHolder$GroupOnPageChangeListener.jdField_a_of_type_Boolean)
    {
      SLog.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "requestSelectedImpl ignore");
      return false;
    }
    if (paramVideoHolderBase == null)
    {
      SLog.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "requestSelected, %s => null", new Object[] { this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoHolderBase });
      paramVideoHolderBase = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoHolderBase;
      if (paramVideoHolderBase != null) {
        paramVideoHolderBase.a(false);
      }
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoHolderBase = null;
      return false;
    }
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoHolderBase;
    VideoViewVideoHolder localVideoViewVideoHolder;
    if (localObject != paramVideoHolderBase)
    {
      SLog.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "requestSelected, %s => %s", new Object[] { localObject, paramVideoHolderBase });
      localObject = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoHolderBase;
      if (localObject != null) {
        ((VideoHolderBase)localObject).a(false);
      }
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoHolderBase = paramVideoHolderBase;
      localObject = paramVideoHolderBase.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder;
      SLog.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "requestSelected, mark position, groupId=%s, vid=%s", ((StoryPlayerGroupHolder)localObject).jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.jdField_a_of_type_JavaLangString, paramVideoHolderBase.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilMap.put(((StoryPlayerGroupHolder)localObject).jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.jdField_a_of_type_JavaLangString, paramVideoHolderBase.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.jdField_a_of_type_JavaLangString);
      boolean bool1;
      if (((StoryPlayerGroupHolder)localObject).b == ((StoryPlayerGroupHolder)localObject).jdField_a_of_type_JavaUtilList.size() - 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      boolean bool2;
      if (((StoryPlayerGroupHolder)localObject).b == 0) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      boolean bool3 = bool1;
      if (bool1)
      {
        bool3 = bool1;
        if (((StoryPlayerGroupHolder)localObject).d()) {
          bool3 = false;
        }
      }
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setEnableScrollDirection(bool3, bool2, true, true);
      localObject = (ProgressBarVideoInfoWidget)((StoryPlayerGroupHolder)localObject).b(ProgressBarVideoInfoWidget.class);
      if (localObject != null)
      {
        localVideoViewVideoHolder = (VideoViewVideoHolder)paramVideoHolderBase.a(VideoViewVideoHolder.class);
        if (localVideoViewVideoHolder != null) {
          ((ProgressBarVideoInfoWidget)localObject).a(localVideoViewVideoHolder.a);
        }
      }
      paramVideoHolderBase.a(true);
      return true;
    }
    if (!paramVideoHolderBase.c())
    {
      SLog.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "requestSelected, selection re-trigger, %s", new Object[] { paramVideoHolderBase });
      localObject = paramVideoHolderBase.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder;
      SLog.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "requestSelected, mark position, groupId=%s, vid=%s", ((StoryPlayerGroupHolder)localObject).jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.jdField_a_of_type_JavaLangString, paramVideoHolderBase.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilMap.put(((StoryPlayerGroupHolder)localObject).jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.jdField_a_of_type_JavaLangString, paramVideoHolderBase.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.jdField_a_of_type_JavaLangString);
      localObject = (ProgressBarVideoInfoWidget)((StoryPlayerGroupHolder)localObject).b(ProgressBarVideoInfoWidget.class);
      if (localObject != null)
      {
        localVideoViewVideoHolder = (VideoViewVideoHolder)paramVideoHolderBase.a(VideoViewVideoHolder.class);
        if (localVideoViewVideoHolder != null) {
          ((ProgressBarVideoInfoWidget)localObject).a(localVideoViewVideoHolder.a);
        }
      }
      paramVideoHolderBase.a(true);
      return true;
    }
    return false;
  }
  
  public void b()
  {
    VideoHolderBase localVideoHolderBase = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoHolderBase;
    if ((localVideoHolderBase != null) && (localVideoHolderBase.c())) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoHolderBase.a(false);
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetPromoteWidgetController.a(this);
  }
  
  public boolean c()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoHolderBase;
    if (localObject != null)
    {
      localObject = (VideoViewVideoHolder)((VideoHolderBase)localObject).a(VideoViewVideoHolder.class);
      if (localObject != null) {
        ((VideoViewVideoHolder)localObject).d = 2;
      }
    }
    StoryReportor.a("play_video", "clk_back", 0, 0, new String[0]);
    return this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetPromoteWidgetController.c();
  }
  
  public void d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGlobalHolder
 * JD-Core Version:    0.7.0.1
 */