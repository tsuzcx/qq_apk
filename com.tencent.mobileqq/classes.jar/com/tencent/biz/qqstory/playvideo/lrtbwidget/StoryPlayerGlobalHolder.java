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
import com.tencent.mobileqq.statistics.CaughtExceptionReport;
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
    this.jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131381588);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager = ((XViewPager)this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.jdField_a_of_type_JavaLangString = "XViewPager_Vertical";
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setEnableScrollDirection(false, false, true, true);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetPromoteWidgetController = new PromoteWidgetController();
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setOverScrollMode(2);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setEnableOverScroll(true);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setPageTransformer(true, new PageTransformerWrapper(new ThreeDTransformer(true, true)));
    int i = (int)paramViewGroup.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setPageTurningThreshold(0.4F);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setDistanceAndVelocityThreshold(i * 10, i * 80);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter = new StoryPlayerGroupAdapter(this);
    paramViewGroup = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter;
    Object localObject = new StoryPlayerGlobalHolder.VideoOnPageChangeListener(this, null);
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
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      IDataProvider.GroupInfo localGroupInfo = (IDataProvider.GroupInfo)localIterator.next();
      if (localGroupInfo.c()) {
        localArrayList.add(localGroupInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.jdField_a_of_type_JavaLangString + "(Loading)");
      } else if (localGroupInfo.b()) {
        localArrayList.add(localGroupInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.jdField_a_of_type_JavaLangString + "(Error)");
      } else {
        localArrayList.add(localGroupInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.jdField_a_of_type_JavaLangString + "(" + localGroupInfo.jdField_a_of_type_JavaUtilList.size() + ")");
      }
    }
    SLog.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", paramString + ", size=%d, list=%s", Integer.valueOf(paramList.size()), localArrayList);
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
      if ((TextUtils.isEmpty(str)) || (str.startsWith("LoadingGroup")) || (str.startsWith("ErrorGroup")))
      {
        if (!TextUtils.isEmpty(localGroupInfo.jdField_a_of_type_JavaLangString))
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
      else if ((!TextUtils.isEmpty(str)) && (!localGroupInfo.jdField_a_of_type_JavaUtilList.contains(str)))
      {
        SLog.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, mark position, groupId=%s, CURRENT ! old=%s", localGroupInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.jdField_a_of_type_JavaLangString, str);
        this.jdField_a_of_type_JavaUtilMap.put(localGroupInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.jdField_a_of_type_JavaLangString, null);
      }
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetPromoteWidgetController.a(paramData, paramGroupId.jdField_a_of_type_JavaLangString);
    int i;
    int j;
    int k;
    label464:
    int n;
    int m;
    label567:
    label611:
    int i2;
    label689:
    label736:
    int i3;
    label897:
    label922:
    label941:
    int i1;
    if (this.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      this.jdField_a_of_type_JavaUtilList.addAll(paramData.jdField_a_of_type_JavaUtilList);
      i = 1;
      j = 1;
      k = 1;
      a("onBind, currentGroupInfoList", this.jdField_a_of_type_JavaUtilList);
      localArrayList.clear();
      localArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
      n = 0;
      m = 0;
      if (i == 0) {
        break label1743;
      }
      SLog.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "firstGroupInfo = %s", new Object[] { (IDataProvider.GroupInfo)localArrayList.get(0) });
      if (paramData.jdField_a_of_type_Boolean) {
        break label1723;
      }
      if ((paramData.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage == null) || (paramData.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()))
      {
        if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetUIGroupInfo != null) && (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetUIGroupInfo.c())) {
          break label2029;
        }
        i = 1;
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetUIGroupInfo = new UIGroupInfo("top_" + SystemClock.uptimeMillis(), true);
        localArrayList.add(0, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetUIGroupInfo);
        if (j == 0) {
          break label1848;
        }
        SLog.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "lastGroupInfo = %s", new Object[] { (IDataProvider.GroupInfo)localArrayList.get(localArrayList.size() - 1) });
        if (paramData.jdField_b_of_type_Boolean) {
          break label1827;
        }
        if ((paramData.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage != null) && (!paramData.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())) {
          break label1769;
        }
        if ((this.b != null) && (this.b.c())) {
          break label2026;
        }
        i = 1;
        this.b = new UIGroupInfo("bottom_" + SystemClock.uptimeMillis(), false);
        localArrayList.add(this.b);
        j = i;
        a("onBind, allGroupInfoList", localArrayList);
        if ((j != 0) || (k != 0)) {
          break label1874;
        }
        SLog.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, ignore because nothing changed");
      }
    }
    else
    {
      localObject = (IDataProvider.GroupInfo)localArrayList.get(0);
      i2 = this.jdField_a_of_type_JavaUtilList.indexOf(localObject);
      localObject = (IDataProvider.GroupInfo)localArrayList.get(localArrayList.size() - 1);
      i3 = this.jdField_a_of_type_JavaUtilList.indexOf(localObject);
      SLog.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, firstPosition=%d, lastPosition=%d", Integer.valueOf(i2), Integer.valueOf(i3));
      if (i2 == -1) {
        break label2071;
      }
      m = i2;
      i = 0;
      j = 0;
      k = 0;
      n = 0;
      if (n >= localArrayList.size()) {
        break label2068;
      }
      if (m < this.jdField_a_of_type_JavaUtilList.size())
      {
        localObject = (IDataProvider.GroupInfo)this.jdField_a_of_type_JavaUtilList.get(m);
        localGroupInfo = (IDataProvider.GroupInfo)localArrayList.get(n);
        if (localGroupInfo == null) {
          break label1269;
        }
        if (m != 0) {
          break label2065;
        }
        k = 1;
        if (m != this.jdField_a_of_type_JavaUtilList.size() - 1) {
          break label2062;
        }
        j = 1;
        if (localObject == null) {
          break label1238;
        }
        if ((((IDataProvider.GroupInfo)localObject).equals(localGroupInfo)) && (((IDataProvider.GroupInfo)localObject).b() == localGroupInfo.b()) && (((IDataProvider.GroupInfo)localObject).c() == localGroupInfo.c())) {
          break label1047;
        }
        SLog.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, --, the group info replace !! old = %s, new = %s", new Object[] { ((IDataProvider.GroupInfo)localObject).jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId, localGroupInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId });
        this.jdField_a_of_type_JavaUtilList.set(m, localGroupInfo);
        i = 1;
      }
      label1169:
      for (;;)
      {
        n += 1;
        m += 1;
        break;
        localObject = null;
        break label897;
        label1047:
        if (((IDataProvider.GroupInfo)localObject).jdField_a_of_type_JavaUtilList.size() != localGroupInfo.jdField_a_of_type_JavaUtilList.size())
        {
          SLog.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, --, the group info update !! groupId=%s, old vid list = %s, new vid list = %s", ((IDataProvider.GroupInfo)localObject).jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId, ((IDataProvider.GroupInfo)localObject).jdField_a_of_type_JavaUtilList, localGroupInfo.jdField_a_of_type_JavaUtilList);
          this.jdField_a_of_type_JavaUtilList.set(m, localGroupInfo);
          i = 1;
        }
        else
        {
          i1 = 0;
          for (;;)
          {
            if (i1 >= ((IDataProvider.GroupInfo)localObject).jdField_a_of_type_JavaUtilList.size()) {
              break label2056;
            }
            if (!TextUtils.equals((CharSequence)((IDataProvider.GroupInfo)localObject).jdField_a_of_type_JavaUtilList.get(i1), (CharSequence)localGroupInfo.jdField_a_of_type_JavaUtilList.get(i1)))
            {
              i1 = 0;
              if (i1 == 0)
              {
                SLog.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, --, the group info update, vid list size equal !! groupId=%s, old vid list = %s, new vid list = %s", new Object[] { ((IDataProvider.GroupInfo)localObject).jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId, ((IDataProvider.GroupInfo)localObject).jdField_a_of_type_JavaUtilList, localGroupInfo.jdField_a_of_type_JavaUtilList });
                this.jdField_a_of_type_JavaUtilList.set(m, localGroupInfo);
                i = 1;
              }
              break;
            }
            i1 += 1;
          }
          label1238:
          SLog.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, --, new group info = %s", localGroupInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId);
          this.jdField_a_of_type_JavaUtilList.add(m, localGroupInfo);
          i = 1;
        }
      }
      label1269:
      SLog.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, --, new group info is null !!");
    }
    for (;;)
    {
      if ((i2 == -1) && (i3 != -1))
      {
        n = localArrayList.size() - 1;
        m = i3;
        if (n >= 0)
        {
          if (m >= 0)
          {
            localObject = (IDataProvider.GroupInfo)this.jdField_a_of_type_JavaUtilList.get(m);
            label1328:
            localGroupInfo = (IDataProvider.GroupInfo)localArrayList.get(n);
            if (localGroupInfo == null) {
              break label1573;
            }
            if (m == 0) {
              k = 1;
            }
            if (m == this.jdField_a_of_type_JavaUtilList.size() - 1) {
              j = 1;
            }
            if (localObject == null) {
              break label1543;
            }
            if ((((IDataProvider.GroupInfo)localObject).equals(localGroupInfo)) && (((IDataProvider.GroupInfo)localObject).b() == localGroupInfo.b()) && (((IDataProvider.GroupInfo)localObject).c() == localGroupInfo.c())) {
              break label1478;
            }
            SLog.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, top, the group info replace !! old = %s, new = %s", new Object[] { ((IDataProvider.GroupInfo)localObject).jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId, localGroupInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId });
            this.jdField_a_of_type_JavaUtilList.set(m, localGroupInfo);
            i = 1;
          }
          for (;;)
          {
            label1457:
            n -= 1;
            m -= 1;
            break;
            localObject = null;
            break label1328;
            label1478:
            if (((IDataProvider.GroupInfo)localObject).jdField_a_of_type_JavaUtilList.size() == localGroupInfo.jdField_a_of_type_JavaUtilList.size()) {
              break label2047;
            }
            SLog.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, top, the group info update !! groupId=%s, old vid list = %s, new vid list = %s", ((IDataProvider.GroupInfo)localObject).jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId, ((IDataProvider.GroupInfo)localObject).jdField_a_of_type_JavaUtilList, localGroupInfo.jdField_a_of_type_JavaUtilList);
            this.jdField_a_of_type_JavaUtilList.set(m, localGroupInfo);
            i = 1;
            continue;
            label1543:
            SLog.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, top, new group info = %s", localGroupInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId);
            this.jdField_a_of_type_JavaUtilList.add(0, localGroupInfo);
            i = 1;
          }
          label1573:
          SLog.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, top, new group info is null !!");
        }
      }
      for (;;)
      {
        if ((i2 == -1) && (i3 == -1))
        {
          if (localArrayList.indexOf(this.jdField_a_of_type_JavaUtilList.get(0)) != -1)
          {
            this.jdField_a_of_type_JavaUtilList.clear();
            this.jdField_a_of_type_JavaUtilList.addAll(paramData.jdField_a_of_type_JavaUtilList);
            i = 1;
            j = 1;
            k = 1;
            break label464;
          }
          SLog.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, data conflict. ignore update !");
          CaughtExceptionReport.a(new Throwable());
          return;
          if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetUIGroupInfo != null)
          {
            i = n;
            if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetUIGroupInfo.b()) {}
          }
          else
          {
            i = 1;
          }
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetUIGroupInfo = new UIGroupInfo(new ErrorMessage(paramData.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage), true);
          localArrayList.add(0, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetUIGroupInfo);
          break label611;
          label1723:
          i = m;
          if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetUIGroupInfo == null) {
            break label611;
          }
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetUIGroupInfo = null;
          i = 1;
          break label611;
          label1743:
          i = m;
          if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetUIGroupInfo == null) {
            break label611;
          }
          localArrayList.add(0, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetUIGroupInfo);
          i = m;
          break label611;
          label1769:
          if ((this.b == null) || (!this.b.b())) {
            i = 1;
          }
          this.b = new UIGroupInfo(new ErrorMessage(paramData.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage), false);
          localArrayList.add(this.b);
          j = i;
          break label736;
          label1827:
          j = i;
          if (this.b == null) {
            break label736;
          }
          this.b = null;
          j = 1;
          break label736;
          label1848:
          j = i;
          if (this.b == null) {
            break label736;
          }
          localArrayList.add(this.b);
          j = i;
          break label736;
          label1874:
          SLog.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, update adapter because changed");
          if (localArrayList.size() <= 0) {
            break;
          }
          i = 0;
          if (i < localArrayList.size()) {
            if (!TextUtils.equals(((IDataProvider.GroupInfo)localArrayList.get(i)).jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.jdField_a_of_type_JavaLangString, paramGroupId.jdField_a_of_type_JavaLangString)) {}
          }
          for (;;)
          {
            SLog.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, currentVerticalPosition=%d, selectedGroupId=%s", Integer.valueOf(i), paramGroupId.jdField_a_of_type_JavaLangString);
            if (i != -1)
            {
              this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter.a(localArrayList);
              SLog.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, setCurrentItem after setDataList, position=%d", new Object[] { Integer.valueOf(i) });
              if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c() == i)
              {
                this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGlobalHolder$GroupOnPageChangeListener.a(i);
                return;
                i += 1;
                break;
              }
              this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setCurrentItem(i, false);
              return;
            }
            SLog.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, data update ignore !!");
            return;
            i = -1;
          }
          label2026:
          break label689;
          label2029:
          i = 0;
          break label567;
        }
        m = i;
        i = k;
        k = m;
        break label464;
        label2047:
        break label1457;
      }
      label2056:
      i1 = 1;
      break label1169;
      label2062:
      break label941;
      label2065:
      break label922;
      label2068:
      continue;
      label2071:
      j = 0;
      k = 0;
      i = 0;
    }
  }
  
  public void a(IDataProvider.GroupId paramGroupId, String paramString, boolean paramBoolean)
  {
    ArrayList localArrayList = null;
    int j = 0;
    int k = 0;
    if ((paramGroupId == null) || (paramString == null))
    {
      SLog.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onGroupDataDelete, deleteGroupId=%s, deleteVid=%s", new Object[] { paramGroupId, paramString });
      return;
    }
    int i = 0;
    label41:
    if (i < this.jdField_a_of_type_JavaUtilList.size()) {
      if (!((IDataProvider.GroupInfo)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.equals(paramGroupId)) {}
    }
    for (;;)
    {
      if (i < 0)
      {
        SLog.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onGroupDataDelete, can not find the group which is deleted ! delete group = %s, vid = %s, isGroupDeleted = %s", new Object[] { paramGroupId.jdField_a_of_type_JavaLangString, paramString, Boolean.valueOf(paramBoolean) });
        return;
        i += 1;
        break label41;
      }
      if (paramBoolean) {
        if (i < this.jdField_a_of_type_JavaUtilList.size() - 1)
        {
          paramGroupId = (IDataProvider.GroupInfo)this.jdField_a_of_type_JavaUtilList.get(i + 1);
          label161:
          this.jdField_a_of_type_JavaUtilList.remove(i);
          paramString = new ArrayList(this.jdField_a_of_type_JavaUtilList);
          if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetUIGroupInfo != null) {
            paramString.add(0, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetUIGroupInfo);
          }
          if (this.b != null) {
            paramString.add(this.b);
          }
          if (paramGroupId != null) {
            break label809;
          }
          paramGroupId = this.b;
        }
      }
      label293:
      label809:
      for (;;)
      {
        if (paramGroupId == null)
        {
          SLog.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onGroupDataDelete, delete one group and then no any more group, exit");
          a().finish();
          return;
          paramGroupId = null;
          break label161;
        }
        SLog.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onGroupDataDelete, delete one group and then play next group, nextGroup = %s", new Object[] { paramGroupId.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.jdField_a_of_type_JavaLangString });
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId = paramGroupId.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId;
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter.a(paramString);
        i = k;
        if (i < paramString.size()) {
          if (!TextUtils.equals(((IDataProvider.GroupInfo)paramString.get(i)).jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.jdField_a_of_type_JavaLangString, paramGroupId.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.jdField_a_of_type_JavaLangString)) {}
        }
        for (;;)
        {
          if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c() == i)
          {
            SLog.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onGroupDataDelete, fake onPageSelected, position = %d", Integer.valueOf(i));
            this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGlobalHolder$GroupOnPageChangeListener.a(i);
            return;
            i += 1;
            break label293;
          }
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setCurrentItem(i, true);
          return;
          Object localObject = (IDataProvider.GroupInfo)this.jdField_a_of_type_JavaUtilList.get(i);
          k = ((IDataProvider.GroupInfo)localObject).jdField_a_of_type_JavaUtilList.indexOf(paramString);
          if (k < 0)
          {
            SLog.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "deletedVid=%s, vidList=%s", new Object[] { paramString, ((IDataProvider.GroupInfo)localObject).jdField_a_of_type_JavaUtilList });
            AssertUtils.a(false, "找不到被删除的vid");
            return;
          }
          if (k < ((IDataProvider.GroupInfo)localObject).jdField_a_of_type_JavaUtilList.size() - 1)
          {
            paramString = (String)((IDataProvider.GroupInfo)localObject).jdField_a_of_type_JavaUtilList.get(k + 1);
            paramGroupId = (IDataProvider.GroupId)localObject;
          }
          for (;;)
          {
            ((IDataProvider.GroupInfo)localObject).jdField_a_of_type_JavaUtilList.remove(k);
            localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilList);
            if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetUIGroupInfo != null) {
              localArrayList.add(0, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetUIGroupInfo);
            }
            if (this.b != null) {
              localArrayList.add(this.b);
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
              if (i < this.jdField_a_of_type_JavaUtilList.size() - 1)
              {
                paramGroupId = (IDataProvider.GroupInfo)this.jdField_a_of_type_JavaUtilList.get(i + 1);
                paramString = localArrayList;
              }
            }
            else
            {
              if (paramString != null)
              {
                paramGroupId = "vid";
                SLog.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "delete one vid and then play next %s, nextGroup = %s, nextVid = %s", new Object[] { paramGroupId, ((IDataProvider.GroupInfo)localObject).jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.jdField_a_of_type_JavaLangString, paramString });
                this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId = ((IDataProvider.GroupInfo)localObject).jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId;
                this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter.a(localArrayList);
                if (paramString != null) {
                  break;
                }
                i = j;
                label687:
                if (i >= localArrayList.size()) {
                  break label789;
                }
                if (!TextUtils.equals(((IDataProvider.GroupInfo)localArrayList.get(i)).jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.jdField_a_of_type_JavaLangString, ((IDataProvider.GroupInfo)localObject).jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.jdField_a_of_type_JavaLangString)) {
                  break label769;
                }
              }
              for (;;)
              {
                if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c() == i)
                {
                  SLog.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onGroupDataDelete, fake onPageSelected, position = %d", Integer.valueOf(i));
                  this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGlobalHolder$GroupOnPageChangeListener.a(i);
                  return;
                  paramGroupId = "group";
                  break;
                  i += 1;
                  break label687;
                }
                this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setCurrentItem(i, true);
                return;
                i = -1;
              }
            }
            paramGroupId = null;
            paramString = localArrayList;
          }
          i = -1;
        }
      }
      label769:
      label789:
      i = -1;
    }
  }
  
  public void a(OnSuperPageChangeListener paramOnSuperPageChangeListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetOnSuperPageChangeListener = paramOnSuperPageChangeListener;
  }
  
  public boolean a(@Nullable VideoHolderBase paramVideoHolderBase)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGlobalHolder$GroupOnPageChangeListener.jdField_a_of_type_Boolean) {
      SLog.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "requestSelectedImpl ignore");
    }
    VideoViewVideoHolder localVideoViewVideoHolder;
    label292:
    do
    {
      return false;
      if (paramVideoHolderBase == null)
      {
        SLog.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "requestSelected, %s => null", new Object[] { this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoHolderBase });
        if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoHolderBase != null) {
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoHolderBase.a(false);
        }
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoHolderBase = null;
        return false;
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoHolderBase != paramVideoHolderBase)
      {
        SLog.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "requestSelected, %s => %s", new Object[] { this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoHolderBase, paramVideoHolderBase });
        if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoHolderBase != null) {
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoHolderBase.a(false);
        }
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoHolderBase = paramVideoHolderBase;
        localObject = paramVideoHolderBase.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder;
        SLog.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "requestSelected, mark position, groupId=%s, vid=%s", ((StoryPlayerGroupHolder)localObject).jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.jdField_a_of_type_JavaLangString, paramVideoHolderBase.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_JavaUtilMap.put(((StoryPlayerGroupHolder)localObject).jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.jdField_a_of_type_JavaLangString, paramVideoHolderBase.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.jdField_a_of_type_JavaLangString);
        boolean bool1;
        if (((StoryPlayerGroupHolder)localObject).b == ((StoryPlayerGroupHolder)localObject).jdField_a_of_type_JavaUtilList.size() - 1)
        {
          bool1 = true;
          if (((StoryPlayerGroupHolder)localObject).b != 0) {
            break label292;
          }
        }
        for (boolean bool2 = true;; bool2 = false)
        {
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
          bool1 = false;
          break;
        }
      }
    } while (paramVideoHolderBase.c());
    SLog.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "requestSelected, selection re-trigger, %s", new Object[] { paramVideoHolderBase });
    Object localObject = paramVideoHolderBase.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder;
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
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoHolderBase != null) && (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoHolderBase.c())) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoHolderBase.a(false);
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetPromoteWidgetController.a(this);
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoHolderBase != null)
    {
      VideoViewVideoHolder localVideoViewVideoHolder = (VideoViewVideoHolder)this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoHolderBase.a(VideoViewVideoHolder.class);
      if (localVideoViewVideoHolder != null) {
        localVideoViewVideoHolder.d = 2;
      }
    }
    StoryReportor.a("play_video", "clk_back", 0, 0, new String[0]);
    return this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetPromoteWidgetController.c();
  }
  
  public void d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGlobalHolder
 * JD-Core Version:    0.7.0.1
 */