package com.tencent.avgame.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.avgame.adapter.GamePKResultRankAdapter;
import com.tencent.avgame.business.handler.UserInfoHandler;
import com.tencent.avgame.gamelogic.data.SurvivalPkResultInfo.Pair;
import com.tencent.avgame.util.AVGameUtil;
import com.tencent.avgame.util.QrCodeUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.util.UiThreadUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class AVGamePKPosterView
  extends RelativeLayout
{
  private IGamePosterView a;
  private ImageView b;
  private RelativeLayout c;
  private ImageView d;
  private TextView e;
  private TextView f;
  private LinearLayout g;
  private AVGameSplitNumberView h;
  private TextView i;
  private LinearLayout j;
  private TextView k;
  private ImageView l;
  private ImageView m;
  private ImageView n;
  private TextView o;
  private ImageView p;
  private ImageView q;
  private UserInfoHandler r;
  private GamePKResultRankAdapter s = null;
  
  public AVGamePKPosterView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public AVGamePKPosterView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public AVGamePKPosterView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private HashMap<String, String> a(UserInfoHandler paramUserInfoHandler, List<SurvivalPkResultInfo.Pair<Integer, Long>> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(String.valueOf(((SurvivalPkResultInfo.Pair)paramList.next()).second));
    }
    return paramUserInfoHandler.a(localArrayList);
  }
  
  private void b(int paramInt)
  {
    AVGameSplitNumberView localAVGameSplitNumberView = this.h;
    if ((localAVGameSplitNumberView != null) && (localAVGameSplitNumberView.getVisibility() == 0)) {
      this.h.a(paramInt);
    }
  }
  
  private boolean c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    paramString = QrCodeUtil.a(paramString, 98, -16777216, 0, Bitmap.Config.ARGB_8888);
    if (paramString != null)
    {
      if (paramString.isRecycled()) {
        return false;
      }
      this.b.setImageBitmap(paramString);
      return true;
    }
    return false;
  }
  
  protected void a()
  {
    LayoutInflater.from(getContext()).inflate(2131624277, this);
    this.b = ((ImageView)findViewById(2131440554));
    this.c = ((RelativeLayout)findViewById(2131440570));
    this.d = ((ImageView)findViewById(2131440566));
    this.e = ((TextView)findViewById(2131440563));
    this.f = ((TextView)findViewById(2131440564));
    this.g = ((LinearLayout)findViewById(2131440562));
    this.k = ((TextView)findViewById(2131440561));
    this.l = ((ImageView)findViewById(2131440548));
    this.n = ((ImageView)findViewById(2131440550));
    this.o = ((TextView)findViewById(2131440559));
    this.j = ((LinearLayout)findViewById(2131440560));
    this.h = ((AVGameSplitNumberView)findViewById(2131440569));
    this.i = ((TextView)findViewById(2131440568));
    this.m = ((ImageView)findViewById(2131440549));
    this.p = ((ImageView)findViewById(2131440557));
    this.q = ((ImageView)findViewById(2131440572));
  }
  
  public void a(int paramInt)
  {
    Object localObject = AVGameUtil.c("avgame_pk_result_win2@2x.png");
    if (localObject != null) {
      this.d.setBackgroundDrawable(new BitmapDrawable((Bitmap)localObject));
    }
    localObject = AVGameUtil.c("avgame_pk_result_win1@2x.png");
    if (localObject != null) {
      this.l.setBackgroundDrawable(new BitmapDrawable((Bitmap)localObject));
    }
    localObject = AVGameUtil.c("avgame_pk_result_footing@2x.png");
    if (localObject != null) {
      this.m.setBackgroundDrawable(new BitmapDrawable((Bitmap)localObject));
    }
    b(1);
    localObject = this.i;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("/");
    localStringBuilder.append(paramInt);
    ((TextView)localObject).setText(localStringBuilder.toString());
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.q.setVisibility(0);
    Object localObject = AVGameUtil.c("avgame_pk_result_fail_spider@2x.png");
    if (localObject != null) {
      this.q.setBackgroundDrawable(new BitmapDrawable((Bitmap)localObject));
    }
    localObject = AVGameUtil.c("avgame_pk_result_fail2@2x.png");
    if (localObject != null) {
      this.d.setBackgroundDrawable(new BitmapDrawable((Bitmap)localObject));
    }
    localObject = AVGameUtil.c("avgame_pk_result_fail1@2x.png");
    if (localObject != null) {
      this.l.setBackgroundDrawable(new BitmapDrawable((Bitmap)localObject));
    }
    localObject = AVGameUtil.c("avgame_pk_result_footing2@2x.png");
    if (localObject != null) {
      this.m.setBackgroundDrawable(new BitmapDrawable((Bitmap)localObject));
    }
    b(paramInt1);
    localObject = this.i;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("/");
    localStringBuilder.append(paramInt2);
    ((TextView)localObject).setText(localStringBuilder.toString());
  }
  
  public void a(UserInfoHandler paramUserInfoHandler, String paramString, Bitmap paramBitmap)
  {
    this.e.setTypeface(AVGameText.getTypeface());
    this.f.setTypeface(AVGameText.getTypeface());
    this.k.setTypeface(AVGameText.getTypeface());
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.j.getLayoutParams();
    localLayoutParams.leftMargin = 74;
    localLayoutParams.rightMargin = 74;
    this.n.setImageBitmap(paramBitmap);
    if (paramString != null) {
      this.o.setText(paramString);
    }
    paramString = AVGameUtil.c("avgame_room_bg@2x.png");
    if (paramString != null) {
      this.c.setBackgroundDrawable(new BitmapDrawable(paramString));
    }
    paramString = AVGameUtil.c("avgame_pk_poster_logo@2x.png");
    if (paramString != null) {
      this.p.setBackgroundDrawable(new BitmapDrawable(paramString));
    }
    this.r = paramUserInfoHandler;
    this.h.setDimension(98, 134);
    paramUserInfoHandler = this.h;
    paramUserInfoHandler.setNumDrawable(paramUserInfoHandler.a("avgame_pk_result_num%d@2x.png"));
  }
  
  public boolean a(String paramString)
  {
    return c(paramString);
  }
  
  public void b()
  {
    GamePKResultRankAdapter localGamePKResultRankAdapter = this.s;
    if (localGamePKResultRankAdapter != null) {
      localGamePKResultRankAdapter.a(a(this.r, localGamePKResultRankAdapter.a()));
    }
  }
  
  public void b(String paramString)
  {
    UiThreadUtil.a(new AVGamePKPosterView.1(this, paramString));
  }
  
  public String c()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(UUID.randomUUID().toString());
    ((StringBuilder)localObject).append(".png");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_FILE_SAVE_TMP_PATH);
    localStringBuilder.append(File.separator);
    localStringBuilder.append((String)localObject);
    return localStringBuilder.toString();
  }
  
  public void setPresenter(IGamePosterView paramIGamePosterView)
  {
    this.a = paramIGamePosterView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGamePKPosterView
 * JD-Core Version:    0.7.0.1
 */