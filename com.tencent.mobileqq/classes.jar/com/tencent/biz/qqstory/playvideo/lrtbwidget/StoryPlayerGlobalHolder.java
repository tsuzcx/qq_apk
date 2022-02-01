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
  @NonNull
  public final XViewPager b;
  @NonNull
  final PromoteWidgetController c;
  private final StoryPlayerGlobalHolder.GroupOnPageChangeListener d;
  private final StoryPlayerGlobalHolder.VideoOnPageChangeListener e;
  private final VideoViewVideoHolder.VideoViewListener f;
  @NonNull
  private final StoryPlayerGroupAdapter g;
  private OnSuperPageChangeListener h;
  private List<IDataProvider.GroupInfo> i = new LinkedList();
  private UIGroupInfo j;
  private UIGroupInfo k;
  private IDataProvider.GroupId l;
  private VideoHolderBase m;
  private Map<String, String> n = new HashMap();
  
  public StoryPlayerGlobalHolder(@NonNull ViewGroup paramViewGroup)
  {
    this.a = paramViewGroup.findViewById(2131449793);
    this.b = ((XViewPager)this.a);
    Object localObject = this.b;
    ((XViewPager)localObject).a = "XViewPager_Vertical";
    ((XViewPager)localObject).setEnableScrollDirection(false, false, true, true);
    this.c = new PromoteWidgetController();
    this.b.setOverScrollMode(2);
    this.b.setEnableOverScroll(true);
    this.b.setPageTransformer(true, new PageTransformerWrapper(new ThreeDTransformer(true, true)));
    int i1 = (int)paramViewGroup.getResources().getDisplayMetrics().density;
    this.b.setPageTurningThreshold(0.4F);
    this.b.setDistanceAndVelocityThreshold(i1 * 10, i1 * 80);
    this.g = new StoryPlayerGroupAdapter(this);
    paramViewGroup = this.g;
    localObject = new StoryPlayerGlobalHolder.VideoOnPageChangeListener(this, null);
    this.e = ((StoryPlayerGlobalHolder.VideoOnPageChangeListener)localObject);
    StoryPlayerGlobalHolder.VideoViewListener localVideoViewListener = new StoryPlayerGlobalHolder.VideoViewListener(this, null);
    this.f = localVideoViewListener;
    paramViewGroup.a((OnSuperPageChangeListener)localObject, localVideoViewListener);
    this.b.setPageMargin(10);
    paramViewGroup = this.b;
    localObject = new StoryPlayerGlobalHolder.GroupOnPageChangeListener(this, null);
    this.d = ((StoryPlayerGlobalHolder.GroupOnPageChangeListener)localObject);
    paramViewGroup.setOnPageChangeListener((XViewPager.OnPageChangeListener)localObject);
    this.b.setAdapter(this.g);
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
        localStringBuilder.append(localGroupInfo.b.b);
        localStringBuilder.append("(Loading)");
        localArrayList.add(localStringBuilder.toString());
      }
      else if (localGroupInfo.b())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(localGroupInfo.b.b);
        localStringBuilder.append("(Error)");
        localArrayList.add(localStringBuilder.toString());
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(localGroupInfo.b.b);
        localStringBuilder.append("(");
        localStringBuilder.append(localGroupInfo.c.size());
        localStringBuilder.append(")");
        localArrayList.add(localStringBuilder.toString());
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(", size=%d, list=%s");
    SLog.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", ((StringBuilder)localObject).toString(), Integer.valueOf(paramList.size()), localArrayList);
  }
  
  @Nullable
  public StoryPlayerGroupHolder a(int paramInt)
  {
    XViewPager.ItemInfo localItemInfo = this.b.b(paramInt);
    if (localItemInfo != null) {
      return (StoryPlayerGroupHolder)localItemInfo.a;
    }
    return null;
  }
  
  public String a(String paramString)
  {
    return (String)this.n.get(paramString);
  }
  
  public void a(IDataProvider.Data paramData, IDataProvider.GroupId paramGroupId)
  {
    SLog.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, up-end=%s, down-end=%s, up-error=%s, down-error=%s, data-size=%d, selectedGroupId=%s", new Object[] { Boolean.valueOf(paramData.b), Boolean.valueOf(paramData.d), paramData.a, paramData.e, Integer.valueOf(paramData.c.size()), paramGroupId.b });
    this.l = paramGroupId;
    ArrayList localArrayList = new ArrayList(paramData.c);
    a("onBind, newGroupInfoList", localArrayList);
    if (localArrayList.size() == 0) {
      return;
    }
    Object localObject = localArrayList.iterator();
    IDataProvider.GroupInfo localGroupInfo;
    while (((Iterator)localObject).hasNext())
    {
      localGroupInfo = (IDataProvider.GroupInfo)((Iterator)localObject).next();
      String str = (String)this.n.get(localGroupInfo.b.b);
      if ((!TextUtils.isEmpty(str)) && (!str.startsWith("LoadingGroup")) && (!str.startsWith("ErrorGroup")))
      {
        if ((!TextUtils.isEmpty(str)) && (!localGroupInfo.c.contains(str)))
        {
          SLog.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, mark position, groupId=%s, CURRENT ! old=%s", localGroupInfo.b.b, str);
          this.n.put(localGroupInfo.b.b, null);
        }
      }
      else if (!TextUtils.isEmpty(localGroupInfo.f))
      {
        SLog.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, mark position, groupId=%s, firstPlayVid=%s", localGroupInfo.b.b, localGroupInfo.f);
        this.n.put(localGroupInfo.b.b, localGroupInfo.f);
      }
      else if (localGroupInfo.c.size() > 0)
      {
        SLog.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, mark position, groupId=%s, first - vid=%s", localGroupInfo.b.b, localGroupInfo.c.get(0));
        this.n.put(localGroupInfo.b.b, localGroupInfo.c.get(0));
      }
      else
      {
        SLog.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, mark position, groupId=%s, vid=%s", localGroupInfo.b.b, null);
        this.n.put(localGroupInfo.b.b, null);
      }
    }
    this.c.a(paramData, paramGroupId.b);
    if (this.i.isEmpty()) {
      this.i.addAll(paramData.c);
    }
    int i1;
    int i2;
    int i3;
    for (;;)
    {
      i1 = 1;
      i2 = 1;
      i3 = 1;
      break label1450;
      localObject = (IDataProvider.GroupInfo)localArrayList.get(0);
      int i9 = this.i.indexOf(localObject);
      localObject = (IDataProvider.GroupInfo)localArrayList.get(localArrayList.size() - 1);
      int i10 = this.i.indexOf(localObject);
      SLog.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, firstPosition=%d, lastPosition=%d", Integer.valueOf(i9), Integer.valueOf(i10));
      if (i9 != -1)
      {
        i5 = i9;
        i4 = 0;
        i2 = 0;
        i3 = 0;
        i1 = 0;
        while (i4 < localArrayList.size())
        {
          if (i5 < this.i.size()) {
            localObject = (IDataProvider.GroupInfo)this.i.get(i5);
          } else {
            localObject = null;
          }
          localGroupInfo = (IDataProvider.GroupInfo)localArrayList.get(i4);
          if (localGroupInfo != null)
          {
            if (i5 == 0) {
              i2 = 1;
            }
            if (i5 == this.i.size() - 1) {
              i3 = 1;
            }
            if (localObject != null)
            {
              if ((((IDataProvider.GroupInfo)localObject).equals(localGroupInfo)) && (((IDataProvider.GroupInfo)localObject).b() == localGroupInfo.b()) && (((IDataProvider.GroupInfo)localObject).c() == localGroupInfo.c()))
              {
                if (((IDataProvider.GroupInfo)localObject).c.size() != localGroupInfo.c.size())
                {
                  SLog.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, --, the group info update !! groupId=%s, old vid list = %s, new vid list = %s", ((IDataProvider.GroupInfo)localObject).b, ((IDataProvider.GroupInfo)localObject).c, localGroupInfo.c);
                  this.i.set(i5, localGroupInfo);
                }
                else
                {
                  i6 = 0;
                  while (i6 < ((IDataProvider.GroupInfo)localObject).c.size())
                  {
                    if (!TextUtils.equals((CharSequence)((IDataProvider.GroupInfo)localObject).c.get(i6), (CharSequence)localGroupInfo.c.get(i6)))
                    {
                      i6 = 0;
                      break label832;
                    }
                    i6 += 1;
                  }
                  i6 = 1;
                  label832:
                  if (i6 == 0)
                  {
                    SLog.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, --, the group info update, vid list size equal !! groupId=%s, old vid list = %s, new vid list = %s", new Object[] { ((IDataProvider.GroupInfo)localObject).b, ((IDataProvider.GroupInfo)localObject).c, localGroupInfo.c });
                    this.i.set(i5, localGroupInfo);
                    i1 = 1;
                  }
                  break label968;
                }
              }
              else
              {
                SLog.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, --, the group info replace !! old = %s, new = %s", new Object[] { ((IDataProvider.GroupInfo)localObject).b, localGroupInfo.b });
                this.i.set(i5, localGroupInfo);
              }
            }
            else
            {
              SLog.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, --, new group info = %s", localGroupInfo.b);
              this.i.add(i5, localGroupInfo);
            }
            i1 = 1;
            label968:
            i5 += 1;
            i4 += 1;
          }
          else
          {
            SLog.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, --, new group info is null !!");
          }
        }
      }
      else
      {
        i2 = 0;
        i3 = 0;
        i1 = 0;
      }
      int i6 = i2;
      int i4 = i3;
      int i5 = i1;
      if (i9 == -1)
      {
        i6 = i2;
        i4 = i3;
        i5 = i1;
        if (i10 != -1)
        {
          int i7 = localArrayList.size() - 1;
          int i8 = i10;
          for (;;)
          {
            i6 = i2;
            i4 = i3;
            i5 = i1;
            if (i7 < 0) {
              break label1352;
            }
            if (i8 >= 0) {
              localObject = (IDataProvider.GroupInfo)this.i.get(i8);
            } else {
              localObject = null;
            }
            localGroupInfo = (IDataProvider.GroupInfo)localArrayList.get(i7);
            if (localGroupInfo == null) {
              break;
            }
            if (i8 == 0) {
              i2 = 1;
            }
            if (i8 == this.i.size() - 1) {
              i3 = 1;
            }
            if (localObject != null)
            {
              if ((((IDataProvider.GroupInfo)localObject).equals(localGroupInfo)) && (((IDataProvider.GroupInfo)localObject).b() == localGroupInfo.b()) && (((IDataProvider.GroupInfo)localObject).c() == localGroupInfo.c()))
              {
                if (((IDataProvider.GroupInfo)localObject).c.size() != localGroupInfo.c.size())
                {
                  SLog.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, top, the group info update !! groupId=%s, old vid list = %s, new vid list = %s", ((IDataProvider.GroupInfo)localObject).b, ((IDataProvider.GroupInfo)localObject).c, localGroupInfo.c);
                  this.i.set(i8, localGroupInfo);
                }
                else
                {
                  break label1318;
                }
              }
              else
              {
                SLog.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, top, the group info replace !! old = %s, new = %s", new Object[] { ((IDataProvider.GroupInfo)localObject).b, localGroupInfo.b });
                this.i.set(i8, localGroupInfo);
              }
            }
            else
            {
              SLog.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, top, new group info = %s", localGroupInfo.b);
              this.i.add(0, localGroupInfo);
            }
            i1 = 1;
            label1318:
            i8 -= 1;
            i7 -= 1;
          }
          SLog.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, top, new group info is null !!");
          i5 = i1;
          i4 = i3;
          i6 = i2;
        }
      }
      label1352:
      i1 = i6;
      i2 = i4;
      i3 = i5;
      if (i9 != -1) {
        break label1450;
      }
      i1 = i6;
      i2 = i4;
      i3 = i5;
      if (i10 != -1) {
        break label1450;
      }
      if (localArrayList.indexOf(this.i.get(0)) == -1) {
        break;
      }
      this.i.clear();
      this.i.addAll(paramData.c);
    }
    SLog.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, data conflict. ignore update !");
    CaughtExceptionReport.a(new Throwable());
    return;
    label1450:
    a("onBind, currentGroupInfoList", this.i);
    localArrayList.clear();
    localArrayList.addAll(this.i);
    if (i1 != 0)
    {
      SLog.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "firstGroupInfo = %s", new Object[] { (IDataProvider.GroupInfo)localArrayList.get(0) });
      if (!paramData.b)
      {
        if ((paramData.a != null) && (!paramData.a.isSuccess()))
        {
          localObject = this.j;
          if ((localObject != null) && (((UIGroupInfo)localObject).b())) {
            i1 = 0;
          } else {
            i1 = 1;
          }
          this.j = new UIGroupInfo(new ErrorMessage(paramData.a), true);
          localArrayList.add(0, this.j);
        }
        else
        {
          localObject = this.j;
          if ((localObject != null) && (((UIGroupInfo)localObject).c())) {
            i1 = 0;
          } else {
            i1 = 1;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("top_");
          ((StringBuilder)localObject).append(SystemClock.uptimeMillis());
          this.j = new UIGroupInfo(((StringBuilder)localObject).toString(), true);
          localArrayList.add(0, this.j);
        }
      }
      else if (this.j != null)
      {
        this.j = null;
        i1 = 1;
      }
      else
      {
        i1 = 0;
      }
    }
    else
    {
      localObject = this.j;
      if (localObject != null) {
        localArrayList.add(0, localObject);
      }
      i1 = 0;
    }
    if (i2 != 0)
    {
      SLog.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "lastGroupInfo = %s", new Object[] { (IDataProvider.GroupInfo)localArrayList.get(localArrayList.size() - 1) });
      if (!paramData.d)
      {
        if ((paramData.e != null) && (!paramData.e.isSuccess()))
        {
          localObject = this.k;
          if ((localObject == null) || (!((UIGroupInfo)localObject).b())) {
            i1 = 1;
          }
          this.k = new UIGroupInfo(new ErrorMessage(paramData.e), false);
          localArrayList.add(this.k);
          i2 = i1;
        }
        else
        {
          paramData = this.k;
          if ((paramData == null) || (!paramData.c())) {
            i1 = 1;
          }
          paramData = new StringBuilder();
          paramData.append("bottom_");
          paramData.append(SystemClock.uptimeMillis());
          this.k = new UIGroupInfo(paramData.toString(), false);
          localArrayList.add(this.k);
          i2 = i1;
        }
      }
      else
      {
        i2 = i1;
        if (this.k != null)
        {
          this.k = null;
          i2 = 1;
        }
      }
    }
    else
    {
      paramData = this.k;
      i2 = i1;
      if (paramData != null)
      {
        localArrayList.add(paramData);
        i2 = i1;
      }
    }
    a("onBind, allGroupInfoList", localArrayList);
    if ((i2 == 0) && (i3 == 0))
    {
      SLog.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, ignore because nothing changed");
      return;
    }
    SLog.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, update adapter because changed");
    if (localArrayList.size() > 0)
    {
      i1 = 0;
      while (i1 < localArrayList.size())
      {
        if (TextUtils.equals(((IDataProvider.GroupInfo)localArrayList.get(i1)).b.b, paramGroupId.b)) {
          break label2056;
        }
        i1 += 1;
      }
      i1 = -1;
      label2056:
      SLog.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, currentVerticalPosition=%d, selectedGroupId=%s", Integer.valueOf(i1), paramGroupId.b);
      if (i1 != -1)
      {
        this.g.a(localArrayList);
        SLog.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, setCurrentItem after setDataList, position=%d", new Object[] { Integer.valueOf(i1) });
        if (this.b.getCurrentItem() == i1)
        {
          this.d.a(i1);
          return;
        }
        this.b.setCurrentItem(i1, false);
        return;
      }
      SLog.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, data update ignore !!");
    }
  }
  
  public void a(IDataProvider.GroupId paramGroupId, String paramString, boolean paramBoolean)
  {
    int i2 = 0;
    int i3 = 0;
    if ((paramGroupId != null) && (paramString != null))
    {
      int i1 = 0;
      while (i1 < this.i.size())
      {
        if (((IDataProvider.GroupInfo)this.i.get(i1)).b.equals(paramGroupId)) {
          break label73;
        }
        i1 += 1;
      }
      i1 = -1;
      label73:
      if (i1 < 0)
      {
        SLog.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onGroupDataDelete, can not find the group which is deleted ! delete group = %s, vid = %s, isGroupDeleted = %s", new Object[] { paramGroupId.b, paramString, Boolean.valueOf(paramBoolean) });
        return;
      }
      ArrayList localArrayList = null;
      paramGroupId = null;
      if (paramBoolean)
      {
        if (i1 < this.i.size() - 1) {
          paramGroupId = (IDataProvider.GroupInfo)this.i.get(i1 + 1);
        }
        this.i.remove(i1);
        localObject = new ArrayList(this.i);
        paramString = this.j;
        if (paramString != null) {
          ((ArrayList)localObject).add(0, paramString);
        }
        paramString = this.k;
        if (paramString != null) {
          ((ArrayList)localObject).add(paramString);
        }
        paramString = paramGroupId;
        if (paramGroupId == null) {
          paramString = this.k;
        }
        if (paramString == null)
        {
          SLog.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onGroupDataDelete, delete one group and then no any more group, exit");
          a().finish();
          return;
        }
        SLog.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onGroupDataDelete, delete one group and then play next group, nextGroup = %s", new Object[] { paramString.b.b });
        this.l = paramString.b;
        this.g.a((ArrayList)localObject);
        i1 = i3;
        while (i1 < ((ArrayList)localObject).size())
        {
          if (TextUtils.equals(((IDataProvider.GroupInfo)((ArrayList)localObject).get(i1)).b.b, paramString.b.b)) {
            break label336;
          }
          i1 += 1;
        }
        i1 = -1;
        label336:
        if (this.b.getCurrentItem() == i1)
        {
          SLog.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onGroupDataDelete, fake onPageSelected, position = %d", Integer.valueOf(i1));
          this.d.a(i1);
          return;
        }
        this.b.setCurrentItem(i1, true);
        return;
      }
      Object localObject = (IDataProvider.GroupInfo)this.i.get(i1);
      i3 = ((IDataProvider.GroupInfo)localObject).c.indexOf(paramString);
      if (i3 < 0)
      {
        SLog.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "deletedVid=%s, vidList=%s", new Object[] { paramString, ((IDataProvider.GroupInfo)localObject).c });
        AssertUtils.assertTrue(false, "找不到被删除的vid");
        return;
      }
      if (i3 < ((IDataProvider.GroupInfo)localObject).c.size() - 1)
      {
        paramString = (String)((IDataProvider.GroupInfo)localObject).c.get(i3 + 1);
        paramGroupId = (IDataProvider.GroupId)localObject;
      }
      else if (i1 < this.i.size() - 1)
      {
        paramGroupId = (IDataProvider.GroupInfo)this.i.get(i1 + 1);
        paramString = localArrayList;
      }
      else
      {
        paramGroupId = null;
        paramString = localArrayList;
      }
      ((IDataProvider.GroupInfo)localObject).c.remove(i3);
      localArrayList = new ArrayList(this.i);
      localObject = this.j;
      if (localObject != null) {
        localArrayList.add(0, localObject);
      }
      localObject = this.k;
      if (localObject != null) {
        localArrayList.add(localObject);
      }
      localObject = paramGroupId;
      if (paramGroupId == null) {
        localObject = this.k;
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
      SLog.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "delete one vid and then play next %s, nextGroup = %s, nextVid = %s", new Object[] { paramGroupId, ((IDataProvider.GroupInfo)localObject).b.b, paramString });
      this.l = ((IDataProvider.GroupInfo)localObject).b;
      this.g.a(localArrayList);
      if (paramString == null)
      {
        i1 = i2;
        while (i1 < localArrayList.size())
        {
          if (TextUtils.equals(((IDataProvider.GroupInfo)localArrayList.get(i1)).b.b, ((IDataProvider.GroupInfo)localObject).b.b)) {
            break label758;
          }
          i1 += 1;
        }
        i1 = -1;
        label758:
        if (this.b.getCurrentItem() == i1)
        {
          SLog.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onGroupDataDelete, fake onPageSelected, position = %d", Integer.valueOf(i1));
          this.d.a(i1);
          return;
        }
        this.b.setCurrentItem(i1, true);
      }
      return;
    }
    SLog.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onGroupDataDelete, deleteGroupId=%s, deleteVid=%s", new Object[] { paramGroupId, paramString });
  }
  
  public void a(OnSuperPageChangeListener paramOnSuperPageChangeListener)
  {
    this.h = paramOnSuperPageChangeListener;
  }
  
  public boolean b(@Nullable VideoHolderBase paramVideoHolderBase)
  {
    if (this.d.c)
    {
      SLog.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "requestSelectedImpl ignore");
      return false;
    }
    if (paramVideoHolderBase == null)
    {
      SLog.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "requestSelected, %s => null", new Object[] { this.m });
      paramVideoHolderBase = this.m;
      if (paramVideoHolderBase != null) {
        paramVideoHolderBase.a(false);
      }
      this.m = null;
      return false;
    }
    Object localObject = this.m;
    VideoViewVideoHolder localVideoViewVideoHolder;
    if (localObject != paramVideoHolderBase)
    {
      SLog.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "requestSelected, %s => %s", new Object[] { localObject, paramVideoHolderBase });
      localObject = this.m;
      if (localObject != null) {
        ((VideoHolderBase)localObject).a(false);
      }
      this.m = paramVideoHolderBase;
      localObject = paramVideoHolderBase.f;
      SLog.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "requestSelected, mark position, groupId=%s, vid=%s", ((StoryPlayerGroupHolder)localObject).e.b, paramVideoHolderBase.c.b);
      this.n.put(((StoryPlayerGroupHolder)localObject).e.b, paramVideoHolderBase.c.b);
      boolean bool1;
      if (((StoryPlayerGroupHolder)localObject).l == ((StoryPlayerGroupHolder)localObject).f.size() - 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      boolean bool2;
      if (((StoryPlayerGroupHolder)localObject).l == 0) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      boolean bool3 = bool1;
      if (bool1)
      {
        bool3 = bool1;
        if (((StoryPlayerGroupHolder)localObject).q()) {
          bool3 = false;
        }
      }
      this.b.setEnableScrollDirection(bool3, bool2, true, true);
      localObject = (ProgressBarVideoInfoWidget)((StoryPlayerGroupHolder)localObject).b(ProgressBarVideoInfoWidget.class);
      if (localObject != null)
      {
        localVideoViewVideoHolder = (VideoViewVideoHolder)paramVideoHolderBase.a(VideoViewVideoHolder.class);
        if (localVideoViewVideoHolder != null) {
          ((ProgressBarVideoInfoWidget)localObject).a(localVideoViewVideoHolder.p);
        }
      }
      paramVideoHolderBase.a(true);
      return true;
    }
    if (!paramVideoHolderBase.f())
    {
      SLog.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "requestSelected, selection re-trigger, %s", new Object[] { paramVideoHolderBase });
      localObject = paramVideoHolderBase.f;
      SLog.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "requestSelected, mark position, groupId=%s, vid=%s", ((StoryPlayerGroupHolder)localObject).e.b, paramVideoHolderBase.c.b);
      this.n.put(((StoryPlayerGroupHolder)localObject).e.b, paramVideoHolderBase.c.b);
      localObject = (ProgressBarVideoInfoWidget)((StoryPlayerGroupHolder)localObject).b(ProgressBarVideoInfoWidget.class);
      if (localObject != null)
      {
        localVideoViewVideoHolder = (VideoViewVideoHolder)paramVideoHolderBase.a(VideoViewVideoHolder.class);
        if (localVideoViewVideoHolder != null) {
          ((ProgressBarVideoInfoWidget)localObject).a(localVideoViewVideoHolder.p);
        }
      }
      paramVideoHolderBase.a(true);
      return true;
    }
    return false;
  }
  
  public void d()
  {
    VideoHolderBase localVideoHolderBase = this.m;
    if ((localVideoHolderBase != null) && (localVideoHolderBase.f())) {
      this.m.a(false);
    }
  }
  
  public void e()
  {
    this.c.a(this);
  }
  
  public List<IDataProvider.GroupInfo> f()
  {
    return this.g.a();
  }
  
  public void g() {}
  
  public boolean h()
  {
    Object localObject = this.m;
    if (localObject != null)
    {
      localObject = (VideoViewVideoHolder)((VideoHolderBase)localObject).a(VideoViewVideoHolder.class);
      if (localObject != null) {
        ((VideoViewVideoHolder)localObject).u = 2;
      }
    }
    StoryReportor.a("play_video", "clk_back", 0, 0, new String[0]);
    return this.c.c();
  }
  
  public IDataProvider.GroupId o()
  {
    return this.l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGlobalHolder
 * JD-Core Version:    0.7.0.1
 */