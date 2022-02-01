package com.tencent.biz.qqstory.album.view;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.album.model.StoryAlbum;
import com.tencent.biz.qqstory.album.model.StoryAlbum.PicInfo;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.image.QQLiveDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class AlbumGalleryAdapterHolder
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  private int A;
  private URLDrawable B;
  public TextView a;
  public TextView b;
  public TextView c;
  public AlbumImageView d;
  public AlbumImageView e;
  public TextView f;
  public TextView g;
  public TextView h;
  public ImageView i;
  public View j;
  public ImageView k;
  public ImageView l;
  public LinearLayout m;
  public ImageView n;
  public TextView o;
  public int p;
  public int q;
  private Drawable r;
  private Handler s;
  private AnimationSet t;
  private AlbumGalleryAdapterHolder.OnHolderItemClickListener u;
  private Activity v;
  private StoryAlbum w;
  private String x;
  private List<StoryAlbum.PicInfo> y;
  private int z;
  
  private int a(List<StoryAlbum.PicInfo> paramList, int paramInt)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return -1;
      }
      int i3 = 0;
      int i1 = Math.max(0, paramInt);
      int i2;
      for (;;)
      {
        i2 = i3;
        if (i1 >= paramList.size()) {
          break;
        }
        if (new File(((StoryAlbum.PicInfo)paramList.get(i1)).b).exists()) {
          return i1;
        }
        i1 += 1;
      }
      while ((i2 < paramList.size()) && (i2 < paramInt))
      {
        if (new File(((StoryAlbum.PicInfo)paramList.get(i2)).b).exists()) {
          return i2;
        }
        i2 += 1;
      }
    }
    return -1;
  }
  
  private void a(int paramInt)
  {
    StoryAlbum localStoryAlbum = this.w;
    if (localStoryAlbum != null) {
      localStoryAlbum.k = paramInt;
    }
  }
  
  private void a(HashSet<View> paramHashSet)
  {
    if (paramHashSet.contains(this.d)) {
      this.d.setVisibility(0);
    } else {
      this.d.setVisibility(8);
    }
    if (paramHashSet.contains(this.e)) {
      this.e.setVisibility(0);
    } else {
      this.e.setVisibility(8);
    }
    if (paramHashSet.contains(this.a)) {
      this.a.setVisibility(0);
    } else {
      this.a.setVisibility(8);
    }
    if (paramHashSet.contains(this.b)) {
      this.b.setVisibility(0);
    } else {
      this.b.setVisibility(8);
    }
    if (paramHashSet.contains(this.c)) {
      this.c.setVisibility(0);
    } else {
      this.c.setVisibility(8);
    }
    if (paramHashSet.contains(this.f)) {
      this.f.setVisibility(0);
    } else {
      this.f.setVisibility(8);
    }
    if (paramHashSet.contains(this.g)) {
      this.g.setVisibility(0);
    } else {
      this.g.setVisibility(8);
    }
    if (paramHashSet.contains(this.h)) {
      this.h.setVisibility(0);
    } else {
      this.h.setVisibility(8);
    }
    if (paramHashSet.contains(this.i)) {
      this.i.setVisibility(0);
    } else {
      this.i.setVisibility(8);
    }
    if (paramHashSet.contains(this.j)) {
      this.j.setVisibility(0);
    } else {
      this.j.setVisibility(8);
    }
    if (paramHashSet.contains(this.k)) {
      this.k.setVisibility(0);
    } else {
      this.k.setVisibility(8);
    }
    if (paramHashSet.contains(this.m)) {
      this.m.setVisibility(0);
    } else {
      this.m.setVisibility(8);
    }
    if (paramHashSet.contains(this.n)) {
      this.n.setVisibility(0);
    } else {
      this.n.setVisibility(8);
    }
    if (paramHashSet.contains(this.o)) {
      this.o.setVisibility(0);
    } else {
      this.o.setVisibility(8);
    }
    if (paramHashSet.contains(this.l))
    {
      this.l.setVisibility(0);
      return;
    }
    this.l.setVisibility(8);
  }
  
  private void c()
  {
    Object localObject = new HashSet();
    ((HashSet)localObject).add(this.d);
    ((HashSet)localObject).add(this.a);
    ((HashSet)localObject).add(this.c);
    ((HashSet)localObject).add(this.g);
    ((HashSet)localObject).add(this.k);
    ((HashSet)localObject).add(this.h);
    ((HashSet)localObject).add(this.j);
    ((HashSet)localObject).add(this.l);
    if (this.w.b() == 0) {
      ((HashSet)localObject).add(this.i);
    }
    if ((this.m.getVisibility() == 0) && (this.m.getAnimation() == null))
    {
      ((HashSet)localObject).add(this.m);
      ((HashSet)localObject).add(this.n);
      ((HashSet)localObject).add(this.o);
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      localAlphaAnimation.setDuration(500L);
      localAlphaAnimation.setStartOffset(500L);
      localAlphaAnimation.setAnimationListener(new AlbumGalleryAdapterHolder.1(this));
      this.m.startAnimation(localAlphaAnimation);
    }
    a((HashSet)localObject);
    localObject = this.y;
    int i1 = a((List)localObject, 0);
    if (i1 < 0) {
      this.d.setImageDrawable(this.r);
    } else {
      this.d.setLocalDrawable(((StoryAlbum.PicInfo)((List)localObject).get(i1)).b, this.p, this.q, this.r);
    }
    this.a.setText(this.w.f);
    if (TextUtils.isEmpty(this.w.a(((List)localObject).size()))) {
      this.c.setText(String.format(HardCodeUtil.a(2131898426), new Object[] { this.w.f, Integer.valueOf(((List)localObject).size()) }));
    } else {
      this.c.setText(this.w.a(((List)localObject).size()));
    }
    this.h.setText(String.valueOf(this.w.c()));
    this.g.setText(this.w.j());
  }
  
  private void d()
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add(this.d);
    localHashSet.add(this.a);
    localHashSet.add(this.c);
    a(localHashSet);
    PlayModeUtils.a(this.d, null, this.x, false, this.p, this.q);
    this.a.setText(HardCodeUtil.a(2131898430));
    this.c.setText(HardCodeUtil.a(2131898432));
  }
  
  private void e()
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add(this.m);
    localHashSet.add(this.a);
    localHashSet.add(this.c);
    localHashSet.add(this.b);
    localHashSet.add(this.n);
    localHashSet.add(this.o);
    a(localHashSet);
    this.n.setImageResource(2130848179);
    this.m.setBackgroundResource(2130848177);
    this.a.setText(HardCodeUtil.a(2131898439));
    this.b.setText(HardCodeUtil.a(2131898424));
    this.c.setText(HardCodeUtil.a(2131898440));
    this.o.setText(HardCodeUtil.a(2131898419));
  }
  
  private void f()
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add(this.m);
    localHashSet.add(this.a);
    localHashSet.add(this.c);
    localHashSet.add(this.b);
    localHashSet.add(this.n);
    localHashSet.add(this.o);
    a(localHashSet);
    this.n.setImageResource(2130848182);
    this.m.setBackgroundResource(2130848177);
    this.a.setText(HardCodeUtil.a(2131898433));
    this.b.setText(HardCodeUtil.a(2131898437));
    this.c.setText(HardCodeUtil.a(2131898443));
    this.o.setText(HardCodeUtil.a(2131898417));
  }
  
  private void g()
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add(this.m);
    localHashSet.add(this.a);
    localHashSet.add(this.c);
    localHashSet.add(this.b);
    localHashSet.add(this.n);
    localHashSet.add(this.o);
    a(localHashSet);
    this.n.setImageResource(2130848178);
    this.m.setBackgroundResource(2130848177);
    this.a.setText(HardCodeUtil.a(2131898441));
    this.b.setText(HardCodeUtil.a(2131898442));
    this.c.setText(HardCodeUtil.a(2131898438));
    this.o.setText(HardCodeUtil.a(2131898420));
  }
  
  private void h()
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add(this.m);
    localHashSet.add(this.a);
    localHashSet.add(this.c);
    localHashSet.add(this.b);
    localHashSet.add(this.m);
    localHashSet.add(this.n);
    localHashSet.add(this.o);
    a(localHashSet);
    this.n.setImageResource(2130848180);
    this.m.setBackgroundResource(2130848177);
    this.a.setText(HardCodeUtil.a(2131898429));
    this.b.setText(HardCodeUtil.a(2131898425));
    this.c.setText(HardCodeUtil.a(2131898434));
    this.o.setText(HardCodeUtil.a(2131898436));
  }
  
  private void i()
  {
    SLog.d("Q.qqstory.recommendAlbum.ui.AlbumGalleryAdapterHolder", "stopPlayLoop");
    this.z = 0;
    this.s.removeCallbacksAndMessages(null);
    this.t.cancel();
    this.d.clearAnimation();
    this.e.clearAnimation();
    this.e.setVisibility(8);
    Object localObject = this.w;
    if (localObject != null)
    {
      localObject = ((StoryAlbum)localObject).a();
      if (((List)localObject).size() > 0) {
        localObject = ((StoryAlbum.PicInfo)((List)localObject).get(0)).b;
      } else {
        localObject = "";
      }
      this.d.setLocalDrawable((String)localObject, this.p, this.q, this.r);
    }
  }
  
  private void j()
  {
    SLog.d("Q.qqstory.recommendAlbum.ui.AlbumGalleryAdapterHolder", "stopPlayMp4");
    this.z = 0;
    Object localObject = this.B;
    if (localObject != null)
    {
      if ((((URLDrawable)localObject).getCurrDrawable() instanceof QQLiveDrawable))
      {
        localObject = (QQLiveDrawable)this.B.getCurrDrawable();
        ((QQLiveDrawable)localObject).release();
        ((QQLiveDrawable)localObject).setOnStateListener(null);
        ((QQLiveDrawable)localObject).setParams(null);
        SLog.b("Q.qqstory.recommendAlbum.ui.AlbumGalleryAdapterHolder", "stopPlayMp4 suc");
      }
      this.e.setURLDrawable(null);
      this.e.setVisibility(8);
      this.B = null;
    }
  }
  
  private int k()
  {
    StoryAlbum localStoryAlbum = this.w;
    if (localStoryAlbum != null) {
      return localStoryAlbum.k;
    }
    return 0;
  }
  
  private void l()
  {
    AlbumImageView localAlbumImageView = this.e;
    if ((localAlbumImageView != null) && (localAlbumImageView.a != null) && ((this.e.a.getCurrDrawable() instanceof QQLiveDrawable))) {
      ((QQLiveDrawable)this.e.a.getCurrDrawable()).release();
    }
  }
  
  private void m()
  {
    SLog.d("Q.qqstory.recommendAlbum.ui.AlbumGalleryAdapterHolder", "stopPlayCenterImg");
    this.z = 0;
    Drawable localDrawable = this.n.getDrawable();
    if ((localDrawable != null) && ((localDrawable instanceof AnimationDrawable))) {
      ((AnimationDrawable)localDrawable).stop();
    }
  }
  
  public void a()
  {
    StoryAlbum localStoryAlbum = this.w;
    if (localStoryAlbum != null) {
      a(localStoryAlbum);
    }
  }
  
  public void a(@NonNull StoryAlbum paramStoryAlbum)
  {
    Object localObject = this.w;
    if ((localObject != null) && (!((StoryAlbum)localObject).equals(paramStoryAlbum)) && (this.z != 0)) {
      b();
    }
    this.w = paramStoryAlbum;
    localObject = this.w.a();
    paramStoryAlbum = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      StoryAlbum.PicInfo localPicInfo = (StoryAlbum.PicInfo)((Iterator)localObject).next();
      if (localPicInfo.a()) {
        paramStoryAlbum.add(localPicInfo);
      }
    }
    this.y = paramStoryAlbum;
    if (this.z == 0)
    {
      if (this.w.d())
      {
        if (this.w.h == 1)
        {
          d();
          return;
        }
        if (this.w.h == 3)
        {
          e();
          return;
        }
        if (this.w.h == 2)
        {
          f();
          return;
        }
        if (this.w.h == 5)
        {
          h();
          return;
        }
        g();
        return;
      }
      c();
    }
  }
  
  public void b()
  {
    StoryAlbum localStoryAlbum = this.w;
    if (localStoryAlbum == null)
    {
      SLog.d("Q.qqstory.recommendAlbum.ui.AlbumGalleryAdapterHolder", "data empty , stopPlay error!");
      return;
    }
    if (this.z == 0) {
      return;
    }
    SLog.a("Q.qqstory.recommendAlbum.ui.AlbumGalleryAdapterHolder", "stop play :%s", localStoryAlbum);
    this.z = 0;
    if (this.w.d())
    {
      if (this.w.h == 1) {
        j();
      } else if (this.w.h == 2) {
        m();
      }
    }
    else {
      i();
    }
    a();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131428173)
    {
      Object localObject = (StoryConfigManager)SuperManager.a(10);
      int i1 = ((Integer)((StoryConfigManager)localObject).c("key_album_delete_dialog_show_count", Integer.valueOf(0))).intValue();
      if (i1 < 3)
      {
        ((StoryConfigManager)localObject).d("key_album_delete_dialog_show_count", Integer.valueOf(i1 + 1));
        localObject = new AlbumGalleryAdapterHolder.2(this);
        localObject = DialogUtil.a(this.v, 230, 2131624611, HardCodeUtil.a(2131898421), null, HardCodeUtil.a(2131898212), HardCodeUtil.a(2131899883), (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject);
        ((QQCustomDialog)localObject).setCancelable(true);
        ((QQCustomDialog)localObject).getWindow().setBackgroundDrawable(new ColorDrawable(0));
        ((QQCustomDialog)localObject).show();
      }
      else
      {
        localObject = this.u;
        if (localObject != null) {
          ((AlbumGalleryAdapterHolder.OnHolderItemClickListener)localObject).a(this.w);
        }
      }
      StoryReportor.a("video_shoot_slides", "delete_smartalbum", 0, 0, new String[] { String.valueOf(this.w.n()), "1" });
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.view.AlbumGalleryAdapterHolder
 * JD-Core Version:    0.7.0.1
 */