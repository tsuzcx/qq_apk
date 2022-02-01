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
  public int a;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private Handler jdField_a_of_type_AndroidOsHandler;
  public View a;
  private AnimationSet jdField_a_of_type_AndroidViewAnimationAnimationSet;
  public ImageView a;
  public LinearLayout a;
  public TextView a;
  private StoryAlbum jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum;
  private AlbumGalleryAdapterHolder.OnHolderItemClickListener jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumGalleryAdapterHolder$OnHolderItemClickListener;
  public AlbumImageView a;
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  private String jdField_a_of_type_JavaLangString;
  private List<StoryAlbum.PicInfo> jdField_a_of_type_JavaUtilList;
  public int b;
  public ImageView b;
  public TextView b;
  public AlbumImageView b;
  private int c;
  public ImageView c;
  public TextView c;
  private int d;
  public ImageView d;
  public TextView d;
  public TextView e;
  public TextView f;
  public TextView g;
  
  private int a()
  {
    StoryAlbum localStoryAlbum = this.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum;
    if (localStoryAlbum != null) {
      return localStoryAlbum.e;
    }
    return 0;
  }
  
  private int a(List<StoryAlbum.PicInfo> paramList, int paramInt)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return -1;
      }
      int k = 0;
      int i = Math.max(0, paramInt);
      int j;
      for (;;)
      {
        j = k;
        if (i >= paramList.size()) {
          break;
        }
        if (new File(((StoryAlbum.PicInfo)paramList.get(i)).jdField_a_of_type_JavaLangString).exists()) {
          return i;
        }
        i += 1;
      }
      while ((j < paramList.size()) && (j < paramInt))
      {
        if (new File(((StoryAlbum.PicInfo)paramList.get(j)).jdField_a_of_type_JavaLangString).exists()) {
          return j;
        }
        j += 1;
      }
    }
    return -1;
  }
  
  private void a(int paramInt)
  {
    StoryAlbum localStoryAlbum = this.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum;
    if (localStoryAlbum != null) {
      localStoryAlbum.e = paramInt;
    }
  }
  
  private void a(HashSet<View> paramHashSet)
  {
    if (paramHashSet.contains(this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumImageView)) {
      this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumImageView.setVisibility(0);
    } else {
      this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumImageView.setVisibility(8);
    }
    if (paramHashSet.contains(this.jdField_b_of_type_ComTencentBizQqstoryAlbumViewAlbumImageView)) {
      this.jdField_b_of_type_ComTencentBizQqstoryAlbumViewAlbumImageView.setVisibility(0);
    } else {
      this.jdField_b_of_type_ComTencentBizQqstoryAlbumViewAlbumImageView.setVisibility(8);
    }
    if (paramHashSet.contains(this.jdField_a_of_type_AndroidWidgetTextView)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    } else {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if (paramHashSet.contains(this.jdField_b_of_type_AndroidWidgetTextView)) {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    } else {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if (paramHashSet.contains(this.jdField_c_of_type_AndroidWidgetTextView)) {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    } else {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if (paramHashSet.contains(this.jdField_d_of_type_AndroidWidgetTextView)) {
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    } else {
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if (paramHashSet.contains(this.e)) {
      this.e.setVisibility(0);
    } else {
      this.e.setVisibility(8);
    }
    if (paramHashSet.contains(this.f)) {
      this.f.setVisibility(0);
    } else {
      this.f.setVisibility(8);
    }
    if (paramHashSet.contains(this.jdField_a_of_type_AndroidWidgetImageView)) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    } else {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if (paramHashSet.contains(this.jdField_a_of_type_AndroidViewView)) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    } else {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    if (paramHashSet.contains(this.jdField_b_of_type_AndroidWidgetImageView)) {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    } else {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if (paramHashSet.contains(this.jdField_a_of_type_AndroidWidgetLinearLayout)) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    } else {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    if (paramHashSet.contains(this.jdField_d_of_type_AndroidWidgetImageView)) {
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
    } else {
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if (paramHashSet.contains(this.g)) {
      this.g.setVisibility(0);
    } else {
      this.g.setVisibility(8);
    }
    if (paramHashSet.contains(this.jdField_c_of_type_AndroidWidgetImageView))
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void c()
  {
    Object localObject = new HashSet();
    ((HashSet)localObject).add(this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumImageView);
    ((HashSet)localObject).add(this.jdField_a_of_type_AndroidWidgetTextView);
    ((HashSet)localObject).add(this.jdField_c_of_type_AndroidWidgetTextView);
    ((HashSet)localObject).add(this.e);
    ((HashSet)localObject).add(this.jdField_b_of_type_AndroidWidgetImageView);
    ((HashSet)localObject).add(this.f);
    ((HashSet)localObject).add(this.jdField_a_of_type_AndroidViewView);
    ((HashSet)localObject).add(this.jdField_c_of_type_AndroidWidgetImageView);
    if (this.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum.a() == 0) {
      ((HashSet)localObject).add(this.jdField_a_of_type_AndroidWidgetImageView);
    }
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 0) && (this.jdField_a_of_type_AndroidWidgetLinearLayout.getAnimation() == null))
    {
      ((HashSet)localObject).add(this.jdField_a_of_type_AndroidWidgetLinearLayout);
      ((HashSet)localObject).add(this.jdField_d_of_type_AndroidWidgetImageView);
      ((HashSet)localObject).add(this.g);
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      localAlphaAnimation.setDuration(500L);
      localAlphaAnimation.setStartOffset(500L);
      localAlphaAnimation.setAnimationListener(new AlbumGalleryAdapterHolder.1(this));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.startAnimation(localAlphaAnimation);
    }
    a((HashSet)localObject);
    localObject = this.jdField_a_of_type_JavaUtilList;
    int i = a((List)localObject, 0);
    if (i < 0) {
      this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    } else {
      this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumImageView.setLocalDrawable(((StoryAlbum.PicInfo)((List)localObject).get(i)).jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum.b);
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum.a(((List)localObject).size()))) {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(String.format(HardCodeUtil.a(2131700389), new Object[] { this.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum.b, Integer.valueOf(((List)localObject).size()) }));
    } else {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum.a(((List)localObject).size()));
    }
    this.f.setText(String.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum.b()));
    this.e.setText(this.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum.a());
  }
  
  private void d()
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add(this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumImageView);
    localHashSet.add(this.jdField_a_of_type_AndroidWidgetTextView);
    localHashSet.add(this.jdField_c_of_type_AndroidWidgetTextView);
    a(localHashSet);
    PlayModeUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumImageView, null, this.jdField_a_of_type_JavaLangString, false, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131700395));
    this.jdField_c_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131700397));
  }
  
  private void e()
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    localHashSet.add(this.jdField_a_of_type_AndroidWidgetTextView);
    localHashSet.add(this.jdField_c_of_type_AndroidWidgetTextView);
    localHashSet.add(this.jdField_b_of_type_AndroidWidgetTextView);
    localHashSet.add(this.jdField_d_of_type_AndroidWidgetImageView);
    localHashSet.add(this.g);
    a(localHashSet);
    this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130846627);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130846625);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131700404));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131700387));
    this.jdField_c_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131700405));
    this.g.setText(HardCodeUtil.a(2131700382));
  }
  
  private void f()
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    localHashSet.add(this.jdField_a_of_type_AndroidWidgetTextView);
    localHashSet.add(this.jdField_c_of_type_AndroidWidgetTextView);
    localHashSet.add(this.jdField_b_of_type_AndroidWidgetTextView);
    localHashSet.add(this.jdField_d_of_type_AndroidWidgetImageView);
    localHashSet.add(this.g);
    a(localHashSet);
    this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130846630);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130846625);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131700398));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131700402));
    this.jdField_c_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131700408));
    this.g.setText(HardCodeUtil.a(2131700380));
  }
  
  private void g()
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    localHashSet.add(this.jdField_a_of_type_AndroidWidgetTextView);
    localHashSet.add(this.jdField_c_of_type_AndroidWidgetTextView);
    localHashSet.add(this.jdField_b_of_type_AndroidWidgetTextView);
    localHashSet.add(this.jdField_d_of_type_AndroidWidgetImageView);
    localHashSet.add(this.g);
    a(localHashSet);
    this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130846626);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130846625);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131700406));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131700407));
    this.jdField_c_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131700403));
    this.g.setText(HardCodeUtil.a(2131700383));
  }
  
  private void h()
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    localHashSet.add(this.jdField_a_of_type_AndroidWidgetTextView);
    localHashSet.add(this.jdField_c_of_type_AndroidWidgetTextView);
    localHashSet.add(this.jdField_b_of_type_AndroidWidgetTextView);
    localHashSet.add(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    localHashSet.add(this.jdField_d_of_type_AndroidWidgetImageView);
    localHashSet.add(this.g);
    a(localHashSet);
    this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130846628);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130846625);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131700393));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131700388));
    this.jdField_c_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131700399));
    this.g.setText(HardCodeUtil.a(2131700401));
  }
  
  private void i()
  {
    SLog.d("Q.qqstory.recommendAlbum.ui.AlbumGalleryAdapterHolder", "stopPlayLoop");
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet.cancel();
    this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumImageView.clearAnimation();
    this.jdField_b_of_type_ComTencentBizQqstoryAlbumViewAlbumImageView.clearAnimation();
    this.jdField_b_of_type_ComTencentBizQqstoryAlbumViewAlbumImageView.setVisibility(8);
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum;
    if (localObject != null)
    {
      localObject = ((StoryAlbum)localObject).a();
      if (((List)localObject).size() > 0) {
        localObject = ((StoryAlbum.PicInfo)((List)localObject).get(0)).jdField_a_of_type_JavaLangString;
      } else {
        localObject = "";
      }
      this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumImageView.setLocalDrawable((String)localObject, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
  }
  
  private void j()
  {
    SLog.d("Q.qqstory.recommendAlbum.ui.AlbumGalleryAdapterHolder", "stopPlayMp4");
    this.jdField_c_of_type_Int = 0;
    Object localObject = this.jdField_a_of_type_ComTencentImageURLDrawable;
    if (localObject != null)
    {
      if ((((URLDrawable)localObject).getCurrDrawable() instanceof QQLiveDrawable))
      {
        localObject = (QQLiveDrawable)this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable();
        ((QQLiveDrawable)localObject).release();
        ((QQLiveDrawable)localObject).setOnStateListener(null);
        ((QQLiveDrawable)localObject).setParams(null);
        SLog.b("Q.qqstory.recommendAlbum.ui.AlbumGalleryAdapterHolder", "stopPlayMp4 suc");
      }
      this.jdField_b_of_type_ComTencentBizQqstoryAlbumViewAlbumImageView.setURLDrawable(null);
      this.jdField_b_of_type_ComTencentBizQqstoryAlbumViewAlbumImageView.setVisibility(8);
      this.jdField_a_of_type_ComTencentImageURLDrawable = null;
    }
  }
  
  private void k()
  {
    AlbumImageView localAlbumImageView = this.jdField_b_of_type_ComTencentBizQqstoryAlbumViewAlbumImageView;
    if ((localAlbumImageView != null) && (localAlbumImageView.jdField_a_of_type_ComTencentImageURLDrawable != null) && ((this.jdField_b_of_type_ComTencentBizQqstoryAlbumViewAlbumImageView.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable() instanceof QQLiveDrawable))) {
      ((QQLiveDrawable)this.jdField_b_of_type_ComTencentBizQqstoryAlbumViewAlbumImageView.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable()).release();
    }
  }
  
  private void l()
  {
    SLog.d("Q.qqstory.recommendAlbum.ui.AlbumGalleryAdapterHolder", "stopPlayCenterImg");
    this.jdField_c_of_type_Int = 0;
    Drawable localDrawable = this.jdField_d_of_type_AndroidWidgetImageView.getDrawable();
    if ((localDrawable != null) && ((localDrawable instanceof AnimationDrawable))) {
      ((AnimationDrawable)localDrawable).stop();
    }
  }
  
  public void a()
  {
    StoryAlbum localStoryAlbum = this.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum;
    if (localStoryAlbum != null) {
      a(localStoryAlbum);
    }
  }
  
  public void a(@NonNull StoryAlbum paramStoryAlbum)
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum;
    if ((localObject != null) && (!((StoryAlbum)localObject).equals(paramStoryAlbum)) && (this.jdField_c_of_type_Int != 0)) {
      b();
    }
    this.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum = paramStoryAlbum;
    localObject = this.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum.a();
    paramStoryAlbum = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      StoryAlbum.PicInfo localPicInfo = (StoryAlbum.PicInfo)((Iterator)localObject).next();
      if (localPicInfo.a()) {
        paramStoryAlbum.add(localPicInfo);
      }
    }
    this.jdField_a_of_type_JavaUtilList = paramStoryAlbum;
    if (this.jdField_c_of_type_Int == 0)
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum.a())
      {
        if (this.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum.jdField_d_of_type_Int == 1)
        {
          d();
          return;
        }
        if (this.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum.jdField_d_of_type_Int == 3)
        {
          e();
          return;
        }
        if (this.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum.jdField_d_of_type_Int == 2)
        {
          f();
          return;
        }
        if (this.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum.jdField_d_of_type_Int == 5)
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
    StoryAlbum localStoryAlbum = this.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum;
    if (localStoryAlbum == null)
    {
      SLog.d("Q.qqstory.recommendAlbum.ui.AlbumGalleryAdapterHolder", "data empty , stopPlay error!");
      return;
    }
    if (this.jdField_c_of_type_Int == 0) {
      return;
    }
    SLog.a("Q.qqstory.recommendAlbum.ui.AlbumGalleryAdapterHolder", "stop play :%s", localStoryAlbum);
    this.jdField_c_of_type_Int = 0;
    if (this.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum.a())
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum.jdField_d_of_type_Int == 1) {
        j();
      } else if (this.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum.jdField_d_of_type_Int == 2) {
        l();
      }
    }
    else {
      i();
    }
    a();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131362560)
    {
      Object localObject = (StoryConfigManager)SuperManager.a(10);
      int i = ((Integer)((StoryConfigManager)localObject).b("key_album_delete_dialog_show_count", Integer.valueOf(0))).intValue();
      if (i < 3)
      {
        ((StoryConfigManager)localObject).b("key_album_delete_dialog_show_count", Integer.valueOf(i + 1));
        localObject = new AlbumGalleryAdapterHolder.2(this);
        localObject = DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230, 2131558978, HardCodeUtil.a(2131700384), null, HardCodeUtil.a(2131700391), HardCodeUtil.a(2131700394), (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject);
        ((QQCustomDialog)localObject).setCancelable(true);
        ((QQCustomDialog)localObject).getWindow().setBackgroundDrawable(new ColorDrawable(0));
        ((QQCustomDialog)localObject).show();
      }
      else
      {
        localObject = this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumGalleryAdapterHolder$OnHolderItemClickListener;
        if (localObject != null) {
          ((AlbumGalleryAdapterHolder.OnHolderItemClickListener)localObject).a(this.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum);
        }
      }
      StoryReportor.a("video_shoot_slides", "delete_smartalbum", 0, 0, new String[] { String.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum.c()), "1" });
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.view.AlbumGalleryAdapterHolder
 * JD-Core Version:    0.7.0.1
 */