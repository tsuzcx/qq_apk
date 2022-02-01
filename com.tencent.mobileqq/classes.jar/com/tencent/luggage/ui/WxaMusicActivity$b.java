package com.tencent.luggage.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.luggage.wxa.rh.a;
import com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader;
import com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.h;
import com.tencent.mm.modelappbrand.image.WxaIconTransformation;
import com.tencent.mm.plugin.appbrand.widget.music.MusicSeekBar;
import com.tencent.mm.plugin.appbrand.widget.music.MusicSeekBar.a;
import com.tencent.mm.ui.e;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/ui/WxaMusicActivity$DefaultMuiscView;", "Lcom/tencent/luggage/ui/WxaMusicActivity$IMuiscView;", "mContext", "Landroid/content/Context;", "mMusicLogic", "Lcom/tencent/luggage/ui/WxaMusicActivity$IMusicLogic;", "(Landroid/content/Context;Lcom/tencent/luggage/ui/WxaMusicActivity$IMusicLogic;)V", "mAvatarIv", "Landroid/widget/ImageView;", "mCloseIv", "mContentView", "Landroid/view/View;", "mNameTv", "Landroid/widget/TextView;", "mNextIv", "mNoContentTv", "mOperationLl", "Landroid/widget/LinearLayout;", "mPlayIv", "mPreIv", "mSeekBar", "Lcom/tencent/mm/plugin/appbrand/widget/music/MusicSeekBar;", "mStopIv", "mTitleTv", "mWxaInfoLl", "adjustMargin", "", "percent", "", "findViewById", "getContentView", "context", "initView", "initViewInner", "updateBusyState", "updateCompleteState", "updateIdleState", "updateLand", "updateMusicTitle", "title", "", "updatePauseState", "updatePlayState", "updatePort", "updateSeekComplete", "updateSeekPostion", "curPos", "totalDuration", "updateWxaAvatar", "icon", "updateWxaName", "name", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class WxaMusicActivity$b
  implements WxaMusicActivity.d
{
  private View a;
  private ImageView b;
  private TextView c;
  private TextView d;
  private LinearLayout e;
  private TextView f;
  private ImageView g;
  private LinearLayout h;
  private MusicSeekBar i;
  private ImageView j;
  private ImageView k;
  private ImageView l;
  private ImageView m;
  private final Context n;
  private final WxaMusicActivity.e o;
  
  public WxaMusicActivity$b(@NotNull Context paramContext, @NotNull WxaMusicActivity.e parame)
  {
    this.n = paramContext;
    this.o = parame;
  }
  
  private final void a(int paramInt)
  {
    Object localObject1 = this.n.getResources();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "mContext.resources");
    paramInt = ((Resources)localObject1).getDisplayMetrics().heightPixels / paramInt;
    localObject1 = this.e;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mWxaInfoLl");
    }
    Object localObject2 = ((LinearLayout)localObject1).getLayoutParams();
    if (localObject2 != null)
    {
      localObject2 = (RelativeLayout.LayoutParams)localObject2;
      ((RelativeLayout.LayoutParams)localObject2).setMargins(0, 0, 0, paramInt);
      ((LinearLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject1 = this.h;
      if (localObject1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mOperationLl");
      }
      localObject2 = ((LinearLayout)localObject1).getLayoutParams();
      if (localObject2 != null)
      {
        localObject2 = (RelativeLayout.LayoutParams)localObject2;
        ((RelativeLayout.LayoutParams)localObject2).setMargins(0, paramInt, 0, 0);
        ((LinearLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        localObject1 = this.i;
        if (localObject1 == null) {
          Intrinsics.throwUninitializedPropertyAccessException("mSeekBar");
        }
        localObject2 = ((MusicSeekBar)localObject1).getLayoutParams();
        if (localObject2 != null)
        {
          localObject2 = (LinearLayout.LayoutParams)localObject2;
          ((LinearLayout.LayoutParams)localObject2).setMargins(0, 0, 0, paramInt / 2);
          ((MusicSeekBar)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
          return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
      }
      throw new TypeCastException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    }
    throw new TypeCastException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
  }
  
  private final void j()
  {
    Object localObject = this.i;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mSeekBar");
    }
    ((MusicSeekBar)localObject).setOnSeekBarChange((MusicSeekBar.a)new WxaMusicActivity.b.a(this));
    localObject = this.i;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mSeekBar");
    }
    ((MusicSeekBar)localObject).setColor(Color.parseColor("#AEAEAE"));
    localObject = this.f;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mNameTv");
    }
    ((TextView)localObject).setOnClickListener((View.OnClickListener)new WxaMusicActivity.b.b(this));
    localObject = this.g;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mAvatarIv");
    }
    ((ImageView)localObject).setOnClickListener((View.OnClickListener)new WxaMusicActivity.b.c(this));
    localObject = this.b;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mCloseIv");
    }
    ((ImageView)localObject).setOnClickListener((View.OnClickListener)new WxaMusicActivity.b.d(this));
    localObject = this.k;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mPlayIv");
    }
    ((ImageView)localObject).setOnClickListener((View.OnClickListener)new WxaMusicActivity.b.e(this));
    localObject = this.l;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mStopIv");
    }
    ((ImageView)localObject).setOnClickListener((View.OnClickListener)new WxaMusicActivity.b.f(this));
    localObject = this.j;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mPreIv");
    }
    ((ImageView)localObject).setOnClickListener((View.OnClickListener)new WxaMusicActivity.b.g(this));
    localObject = this.m;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mNextIv");
    }
    ((ImageView)localObject).setOnClickListener((View.OnClickListener)new WxaMusicActivity.b.h(this));
  }
  
  private final void k()
  {
    Object localObject = this.c;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mNoContentTv");
    }
    ((TextView)localObject).setVisibility(4);
    localObject = this.f;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mNameTv");
    }
    ((TextView)localObject).setVisibility(0);
    localObject = this.e;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mWxaInfoLl");
    }
    ((LinearLayout)localObject).setVisibility(0);
    localObject = this.h;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mOperationLl");
    }
    ((LinearLayout)localObject).setVisibility(0);
  }
  
  @NotNull
  public View a(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    paramContext = View.inflate(paramContext, 2131624033, null);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "View.inflate(context, R.…out.activity_music, null)");
    this.a = paramContext;
    paramContext = this.a;
    if (paramContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mContentView");
    }
    return paramContext;
  }
  
  public void a()
  {
    b();
    j();
    View localView = this.a;
    if (localView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mContentView");
    }
    a.a(localView, WxaMusicActivity.a.a(), e.a(WxaMusicActivity.a.a()) ^ true);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    MusicSeekBar localMusicSeekBar = this.i;
    if (localMusicSeekBar == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mSeekBar");
    }
    localMusicSeekBar.setProgress(paramInt1);
    localMusicSeekBar = this.i;
    if (localMusicSeekBar == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mSeekBar");
    }
    localMusicSeekBar.setMaxProgress(paramInt2);
  }
  
  public void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "icon");
    int i1;
    if (((CharSequence)paramString).length() == 0) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0)
    {
      paramString = this.g;
      if (paramString == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mAvatarIv");
      }
      paramString.setImageResource(2130842125);
      return;
    }
    AppBrandSimpleImageLoader localAppBrandSimpleImageLoader = AppBrandSimpleImageLoader.instance();
    ImageView localImageView = this.g;
    if (localImageView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mAvatarIv");
    }
    localAppBrandSimpleImageLoader.attach(localImageView, paramString, 2130842125, (AppBrandSimpleImageLoader.h)WxaIconTransformation.INSTANCE);
  }
  
  public final void b()
  {
    View localView1 = this.a;
    if (localView1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mContentView");
    }
    View localView2 = localView1.findViewById(2131430833);
    Intrinsics.checkExpressionValueIsNotNull(localView2, "findViewById(R.id.close_iv)");
    this.b = ((ImageView)localView2);
    localView2 = localView1.findViewById(2131429022);
    Intrinsics.checkExpressionValueIsNotNull(localView2, "findViewById(R.id.avatar_iv)");
    this.g = ((ImageView)localView2);
    localView2 = localView1.findViewById(2131439136);
    Intrinsics.checkExpressionValueIsNotNull(localView2, "findViewById(R.id.name_tv)");
    this.f = ((TextView)localView2);
    localView2 = localView1.findViewById(2131450321);
    Intrinsics.checkExpressionValueIsNotNull(localView2, "findViewById(R.id.wxa_info_ll)");
    this.e = ((LinearLayout)localView2);
    localView2 = localView1.findViewById(2131439347);
    Intrinsics.checkExpressionValueIsNotNull(localView2, "findViewById(R.id.no_content_tv)");
    this.c = ((TextView)localView2);
    localView2 = localView1.findViewById(2131447585);
    Intrinsics.checkExpressionValueIsNotNull(localView2, "findViewById(R.id.title_tv)");
    this.d = ((TextView)localView2);
    localView2 = localView1.findViewById(2131439669);
    Intrinsics.checkExpressionValueIsNotNull(localView2, "findViewById(R.id.operation_ll)");
    this.h = ((LinearLayout)localView2);
    localView2 = localView1.findViewById(2131439068);
    Intrinsics.checkExpressionValueIsNotNull(localView2, "findViewById(R.id.music_seek_bar)");
    this.i = ((MusicSeekBar)localView2);
    localView2 = localView1.findViewById(2131440374);
    Intrinsics.checkExpressionValueIsNotNull(localView2, "findViewById(R.id.play_btn)");
    this.k = ((ImageView)localView2);
    localView2 = localView1.findViewById(2131446395);
    Intrinsics.checkExpressionValueIsNotNull(localView2, "findViewById(R.id.stop_btn)");
    this.l = ((ImageView)localView2);
    localView2 = localView1.findViewById(2131440584);
    Intrinsics.checkExpressionValueIsNotNull(localView2, "findViewById(R.id.pre_song)");
    this.j = ((ImageView)localView2);
    localView1 = localView1.findViewById(2131439288);
    Intrinsics.checkExpressionValueIsNotNull(localView1, "findViewById(R.id.next_song)");
    this.m = ((ImageView)localView1);
  }
  
  public void b(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    TextView localTextView = this.f;
    if (localTextView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mNameTv");
    }
    localTextView.setText((CharSequence)paramString);
  }
  
  public void c()
  {
    MusicSeekBar localMusicSeekBar = this.i;
    if (localMusicSeekBar == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mSeekBar");
    }
    localMusicSeekBar.a(false);
  }
  
  public void c(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "title");
    paramString = (CharSequence)paramString;
    int i1;
    if (paramString.length() == 0) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0)
    {
      paramString = this.c;
      if (paramString == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mNoContentTv");
      }
      paramString.setText(this.n.getText(2131892154));
      return;
    }
    TextView localTextView = this.d;
    if (localTextView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mTitleTv");
    }
    localTextView.setText(paramString);
  }
  
  public void d()
  {
    Object localObject = this.c;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mNoContentTv");
    }
    ((TextView)localObject).setVisibility(0);
    localObject = this.f;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mNameTv");
    }
    ((TextView)localObject).setVisibility(4);
    localObject = this.e;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mWxaInfoLl");
    }
    ((LinearLayout)localObject).setVisibility(8);
    localObject = this.h;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mOperationLl");
    }
    ((LinearLayout)localObject).setVisibility(8);
  }
  
  public void e()
  {
    k();
  }
  
  public void f()
  {
    k();
    ImageView localImageView = this.k;
    if (localImageView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mPlayIv");
    }
    localImageView.setVisibility(0);
    localImageView = this.l;
    if (localImageView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mStopIv");
    }
    localImageView.setVisibility(8);
  }
  
  public void g()
  {
    k();
    ImageView localImageView = this.k;
    if (localImageView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mPlayIv");
    }
    localImageView.setVisibility(8);
    localImageView = this.l;
    if (localImageView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mStopIv");
    }
    localImageView.setVisibility(0);
  }
  
  public void h()
  {
    a(20);
  }
  
  public void i()
  {
    a(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.ui.WxaMusicActivity.b
 * JD-Core Version:    0.7.0.1
 */