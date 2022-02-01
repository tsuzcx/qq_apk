package com.tencent.aelight.camera.ae.biz.circle.part;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.OnItemTouchListener;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import com.tencent.aelight.camera.ae.album.data.AEAlbumLogicData;
import com.tencent.aelight.camera.ae.biz.circle.AECircleMultiUnit;
import com.tencent.aelight.camera.ae.biz.circle.AECirclePhotoListLogic;
import com.tencent.aelight.camera.ae.biz.circle.adapter.PhotoPreviewAdapter;
import com.tencent.aelight.camera.ae.biz.circle.event.AECircleChangeBottomTabVisibleEvent;
import com.tencent.aelight.camera.ae.biz.circle.event.AECircleSelectChangeEvent;
import com.tencent.aelight.camera.ae.biz.circle.event.AECircleShowPhotoPreviewEvent;
import com.tencent.aelight.camera.ae.biz.circle.part.base.AECircleBasePart;
import com.tencent.aelight.camera.aebase.AEReportUtils;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListBaseData;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.pull2refresh.PagerSnapHelper;
import com.tencent.widget.pull2refresh.PagerSnapHelper.PagerEventListener;
import com.tencent.widget.pull2refresh.RecyclerViewCompat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class AECirclePreviewPart
  extends AECircleBasePart
  implements View.OnClickListener, SimpleEventReceiver, PagerSnapHelper.PagerEventListener
{
  private RecyclerViewCompat a;
  private PhotoPreviewAdapter b;
  private LinearLayoutManager f;
  private NumberCheckBox g;
  private PagerSnapHelper h;
  private List<LocalMediaInfo> i = new ArrayList();
  private FrameLayout j;
  private FrameLayout k;
  private Button l;
  private float m;
  private int n;
  
  public AECirclePreviewPart(AECirclePhotoListLogic paramAECirclePhotoListLogic)
  {
    super(paramAECirclePhotoListLogic);
    this.c.a(this);
  }
  
  private boolean b(LocalMediaInfo paramLocalMediaInfo)
  {
    if (QAlbumUtil.getMediaType(paramLocalMediaInfo) == 1)
    {
      if (!this.c.g().canPickVideo)
      {
        QQToast.makeText(h(), HardCodeUtil.a(2064187572), 0).show();
        this.g.setChecked(false);
        return false;
      }
      if (!this.c.a(h(), paramLocalMediaInfo))
      {
        this.g.setChecked(false);
        return false;
      }
    }
    return true;
  }
  
  private RecyclerView.OnItemTouchListener e()
  {
    return new AECirclePreviewPart.1(this);
  }
  
  private void j()
  {
    this.j.setVisibility(8);
    SimpleEventBus.getInstance().dispatchEvent(new AECircleChangeBottomTabVisibleEvent());
    AECircleMultiUnit.a(g(), 0, true);
  }
  
  private void k()
  {
    Object localObject1 = (LocalMediaInfo)this.i.get(this.f.findFirstVisibleItemPosition());
    if (((LocalMediaInfo)localObject1).selectStatus == 1) {
      return;
    }
    if (this.c.e().selectedPhotoList.size() + this.c.g().initialHasPickedNum >= this.c.e().maxSelectNum)
    {
      long l1 = System.currentTimeMillis();
      if (l1 - this.c.f().H >= 1000L)
      {
        QQToast.makeText(h(), a((LocalMediaInfo)localObject1), 0).show();
        this.g.setChecked(false);
        this.c.f().H = l1;
      }
      return;
    }
    if (!b((LocalMediaInfo)localObject1)) {
      return;
    }
    ((LocalMediaInfo)localObject1).selectStatus = 1;
    String str = ((LocalMediaInfo)localObject1).path;
    Object localObject2 = MimeHelper.getMimeType(((LocalMediaInfo)localObject1).mMimeType);
    if ((this.c.f().B) && (localObject2 != null) && ("video".equals(localObject2[0])))
    {
      localObject2 = this.c.f();
      ((PhotoListBaseData)localObject2).C += 1;
      if (this.c.f().C == 1) {
        this.c.f().E = ((LocalMediaInfo)localObject1);
      }
    }
    if ((!TextUtils.isEmpty(((LocalMediaInfo)localObject1).mMimeType)) && ("image/gif".equals(((LocalMediaInfo)localObject1).mMimeType)))
    {
      localObject2 = this.c.f();
      ((PhotoListBaseData)localObject2).D += 1;
    }
    this.c.e().selectedPhotoList.add(str);
    this.c.e().selectedIndex.add(((LocalMediaInfo)localObject1).position);
    this.c.e().selectedMediaInfoHashMap.put(str, localObject1);
    localObject2 = (LinkedHashMap)AlbumUtil.sSelectItemPosMap.get(this.c.e().albumId);
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new LinkedHashMap();
      AlbumUtil.sSelectItemPosMap.put(this.c.e().albumId, localObject1);
    }
    ((LinkedHashMap)localObject1).put(str, Integer.valueOf(this.f.findFirstVisibleItemPosition()));
    localObject1 = AlbumUtil.sSelectItemAlbum;
    if (!((HashMap)localObject1).containsKey(str)) {
      ((HashMap)localObject1).put(str, new Pair(this.c.e().albumId, this.c.e().albumName));
    }
    SimpleEventBus.getInstance().dispatchEvent(new AECircleSelectChangeEvent());
  }
  
  private void l()
  {
    LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)this.i.get(this.f.findFirstVisibleItemPosition());
    int i1 = localLocalMediaInfo.selectStatus;
    if ((i1 != 1) && (this.c.e().selectedPhotoList.size() + this.c.g().initialHasPickedNum >= this.c.e().maxSelectNum))
    {
      long l1 = System.currentTimeMillis();
      if (l1 - this.c.f().H >= 1000L)
      {
        QQToast.makeText(h(), a(localLocalMediaInfo), 0).show();
        this.g.setChecked(false);
        this.c.f().H = l1;
      }
      return;
    }
    if (!b(localLocalMediaInfo)) {
      return;
    }
    if (i1 == 1) {
      i1 = 2;
    } else {
      i1 = 1;
    }
    localLocalMediaInfo.selectStatus = i1;
    if (localLocalMediaInfo.selectStatus == 1) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    String str = localLocalMediaInfo.path;
    Object localObject1 = PresendPicMgr.a();
    Object localObject2 = MimeHelper.getMimeType(localLocalMediaInfo.mMimeType);
    if (i1 != 0)
    {
      if ((this.c.f().B) && (localObject2 != null) && ("video".equals(localObject2[0])))
      {
        localObject1 = this.c.f();
        ((PhotoListBaseData)localObject1).C += 1;
        if (this.c.f().C == 1) {
          this.c.f().E = localLocalMediaInfo;
        }
      }
      if ((!TextUtils.isEmpty(localLocalMediaInfo.mMimeType)) && ("image/gif".equals(localLocalMediaInfo.mMimeType)))
      {
        localObject1 = this.c.f();
        ((PhotoListBaseData)localObject1).D += 1;
      }
      this.c.e().selectedPhotoList.add(str);
      this.c.e().selectedIndex.add(localLocalMediaInfo.position);
      this.c.e().selectedMediaInfoHashMap.put(str, localLocalMediaInfo);
      localObject2 = (LinkedHashMap)AlbumUtil.sSelectItemPosMap.get(this.c.e().albumId);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new LinkedHashMap();
        AlbumUtil.sSelectItemPosMap.put(this.c.e().albumId, localObject1);
      }
      ((LinkedHashMap)localObject1).put(str, Integer.valueOf(this.f.findFirstVisibleItemPosition()));
      localObject1 = AlbumUtil.sSelectItemAlbum;
      if (!((HashMap)localObject1).containsKey(str)) {
        ((HashMap)localObject1).put(str, new Pair(this.c.e().albumId, this.c.e().albumName));
      }
    }
    else
    {
      if ((this.c.f().B) && (localObject2 != null) && ("video".equals(localObject2[0])))
      {
        localObject2 = this.c.f();
        ((PhotoListBaseData)localObject2).C -= 1;
        if (this.c.f().C == 1) {
          this.c.f().E = localLocalMediaInfo;
        }
      }
      if ((!TextUtils.isEmpty(localLocalMediaInfo.mMimeType)) && ("image/gif".equals(localLocalMediaInfo.mMimeType)))
      {
        localObject2 = this.c.f();
        ((PhotoListBaseData)localObject2).D -= 1;
      }
      this.c.e().selectedPhotoList.remove(str);
      this.c.e().selectedIndex.remove(localLocalMediaInfo.position);
      this.c.e().selectedMediaInfoHashMap.remove(str);
      if (localObject1 != null) {
        ((PresendPicMgr)localObject1).b(str, 1013);
      }
      localObject1 = (HashMap)AlbumUtil.sSelectItemPosMap.get(this.c.e().albumId);
      if (localObject1 != null) {
        ((HashMap)localObject1).remove(str);
      }
      localObject1 = AlbumUtil.sSelectItemAlbum;
      if (((HashMap)localObject1).containsKey(str)) {
        ((HashMap)localObject1).remove(str);
      }
    }
    i1 = localLocalMediaInfo.selectStatus;
    if (i1 == 1) {
      this.g.setCheckedNumber(this.c.e().selectedPhotoList.indexOf(localLocalMediaInfo.path) + 1 + this.c.g().initialHasPickedNum);
    } else if (i1 == 3) {
      this.g.setChecked(false);
    } else {
      this.g.setChecked(false);
    }
    SimpleEventBus.getInstance().dispatchEvent(new AECircleSelectChangeEvent());
  }
  
  protected String a(LocalMediaInfo paramLocalMediaInfo)
  {
    int i1 = this.c.e().maxSelectNum;
    return h().getResources().getString(2131892559, new Object[] { Integer.valueOf(i1) });
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    int i1 = paramViewHolder.getAdapterPosition();
    LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)this.i.get(i1);
    if (localLocalMediaInfo.selectStatus == 1) {
      this.g.setCheckedNumber(this.c.e().selectedPhotoList.indexOf(localLocalMediaInfo.path) + 1 + this.c.g().initialHasPickedNum);
    } else {
      this.g.setChecked(false);
    }
    if (this.c != null) {
      paramViewHolder = this.c.i();
    } else {
      paramViewHolder = "";
    }
    AEReportUtils.a(QAlbumUtil.getMediaType(localLocalMediaInfo), paramViewHolder);
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    this.a = ((RecyclerViewCompat)paramView.findViewById(2063991297));
    this.g = ((NumberCheckBox)paramView.findViewById(2063991301));
    this.j = ((FrameLayout)paramView.findViewById(2063991304));
    this.k = ((FrameLayout)paramView.findViewById(2063991300));
    this.l = ((Button)paramView.findViewById(2063991302));
    this.l.setOnClickListener(this);
    this.k.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.h = new PagerSnapHelper();
    this.h.a(this);
    this.b = new PhotoPreviewAdapter(h(), this.c);
    this.a.setAdapter(this.b);
    this.f = new LinearLayoutManager(h(), 0, false);
    this.a.setLayoutManager(this.f);
    this.h.a(this.a);
    this.a.addOnItemTouchListener(e());
  }
  
  public void a(List<LocalMediaInfo> paramList)
  {
    this.i.clear();
    this.i.addAll(paramList);
    paramList = this.i.iterator();
    int i1 = 0;
    while (paramList.hasNext())
    {
      LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)paramList.next();
      if ((QAlbumUtil.getMediaType(localLocalMediaInfo) != 2) && ((TextUtils.isEmpty(localLocalMediaInfo.mMimeType)) || (!"image/gif".equals(localLocalMediaInfo.mMimeType))))
      {
        i1 += 1;
      }
      else
      {
        paramList.remove();
        int i2 = this.n;
        if (i2 > i1) {
          this.n = (i2 - 1);
        }
      }
    }
    paramList = this.b;
    if (paramList != null) {
      paramList.a(this.i);
    }
  }
  
  public boolean a()
  {
    FrameLayout localFrameLayout = this.j;
    boolean bool = true;
    if (localFrameLayout != null)
    {
      if (localFrameLayout.getVisibility() != 0) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public boolean am_()
  {
    if (this.j.getVisibility() == 0)
    {
      j();
      return true;
    }
    return false;
  }
  
  public String b()
  {
    return "AECirclePreviewPart";
  }
  
  public void b(RecyclerView.ViewHolder paramViewHolder) {}
  
  public void d() {}
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(AECircleShowPhotoPreviewEvent.class);
    return localArrayList;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2063991301)
    {
      l();
      return;
    }
    if (paramView.getId() == 2063991302)
    {
      if (this.c.e().selectedPhotoList.size() + this.c.g().initialHasPickedNum < 1) {
        k();
      }
      j();
      return;
    }
    if (paramView.getId() == 2063991300) {
      j();
    }
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof AECircleShowPhotoPreviewEvent))
    {
      paramSimpleBaseEvent = (AECircleShowPhotoPreviewEvent)paramSimpleBaseEvent;
      this.n = paramSimpleBaseEvent.mPosition;
      a(paramSimpleBaseEvent.mPhotoInfoList);
      if (this.n >= this.i.size()) {
        return;
      }
      this.a.scrollToPosition(this.n);
      this.j.setVisibility(0);
      AECircleMultiUnit.a(g(), g().getResources().getColor(2131165707), false);
      SimpleEventBus.getInstance().dispatchEvent(new AECircleChangeBottomTabVisibleEvent());
      if (this.c != null) {
        paramSimpleBaseEvent = this.c.i();
      } else {
        paramSimpleBaseEvent = "";
      }
      AEReportUtils.a(QAlbumUtil.getMediaType((LocalMediaInfo)this.i.get(this.n)), paramSimpleBaseEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.part.AECirclePreviewPart
 * JD-Core Version:    0.7.0.1
 */