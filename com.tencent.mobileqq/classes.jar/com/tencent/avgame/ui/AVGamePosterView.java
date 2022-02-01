package com.tencent.avgame.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.avgame.business.handler.UserInfoHandler;
import com.tencent.avgame.gamelogic.data.UserScore;
import com.tencent.avgame.util.AVGameUtil;
import com.tencent.avgame.util.QrCodeUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.UiThreadUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

public class AVGamePosterView
  extends RelativeLayout
{
  protected ImageView a;
  protected LinearLayout b;
  private ImageView c;
  private IGamePosterView d;
  private ImageView e;
  private ImageView f;
  private AVGamePosterCoverView g;
  
  public AVGamePosterView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public AVGamePosterView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public AVGamePosterView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private HashMap<String, String> b(UserInfoHandler paramUserInfoHandler, CopyOnWriteArrayList<UserScore> paramCopyOnWriteArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    paramCopyOnWriteArrayList = paramCopyOnWriteArrayList.iterator();
    while (paramCopyOnWriteArrayList.hasNext()) {
      localArrayList.add(String.valueOf(((UserScore)paramCopyOnWriteArrayList.next()).uin));
    }
    return paramUserInfoHandler.a(localArrayList);
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
      this.e.setImageBitmap(paramString);
      return true;
    }
    return false;
  }
  
  protected void a()
  {
    LayoutInflater.from(getContext()).inflate(2131624279, this);
    this.b = ((LinearLayout)findViewById(2131440545));
    this.a = ((ImageView)findViewById(2131440555));
    this.e = ((ImageView)findViewById(2131440554));
    this.g = ((AVGamePosterCoverView)findViewById(2131440547));
    this.c = ((ImageView)findViewById(2131440552));
    this.f = ((ImageView)findViewById(2131440553));
    Bitmap localBitmap = AVGameUtil.c("avgame_poster_bg@2x.png");
    if (localBitmap != null) {
      this.f.setImageDrawable(new BitmapDrawable(localBitmap));
    }
    int i = ViewUtils.dip2px(150.0F);
    this.g.setAsyncClipSize(i, i);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.g != null)
    {
      if (!TextUtils.isEmpty(paramString1))
      {
        this.g.setAsyncImage(paramString1);
        return;
      }
      if (paramString2 != null)
      {
        paramString1 = AVGameUtil.c(paramString2);
        if (paramString1 != null) {
          this.g.setImageBitmap(paramString1);
        }
      }
    }
  }
  
  public boolean a(UserInfoHandler paramUserInfoHandler, CopyOnWriteArrayList<UserScore> paramCopyOnWriteArrayList)
  {
    if (paramUserInfoHandler != null)
    {
      if (paramCopyOnWriteArrayList == null) {
        return false;
      }
      HashMap localHashMap = b(paramUserInfoHandler, paramCopyOnWriteArrayList);
      this.b.removeAllViews();
      int i = 0;
      while (i < paramCopyOnWriteArrayList.size())
      {
        UserScore localUserScore = (UserScore)paramCopyOnWriteArrayList.get(i);
        try
        {
          View localView = LayoutInflater.from(getContext()).inflate(2131624307, null);
          Object localObject1 = paramUserInfoHandler.a(String.valueOf(localUserScore.uin), (byte)3);
          ((ImageView)localView.findViewById(2131429164)).setImageBitmap((Bitmap)localObject1);
          TextView localTextView = (TextView)localView.findViewById(2131429163);
          Object localObject2 = (String)localHashMap.get(String.valueOf(localUserScore.uin));
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("putUserScores nickName is Empty:");
            ((StringBuilder)localObject1).append(localUserScore.uin);
            QLog.e("AVGamePosterView", 2, ((StringBuilder)localObject1).toString());
            localObject1 = String.valueOf(localUserScore.uin);
          }
          localTextView.setText((CharSequence)localObject1);
          ((TextView)localView.findViewById(2131429160)).setText(String.valueOf(localUserScore.score));
          localObject2 = (TextView)localView.findViewById(2131429143);
          ((TextView)localObject2).setText(String.valueOf(i + 1));
          localObject1 = (ImageView)localView.findViewById(2131429144);
          if (i == 0)
          {
            ((TextView)localObject2).setVisibility(8);
            localObject2 = AVGameUtil.c("avgame_ranking1@2x.png");
            if (localObject2 != null) {
              ((ImageView)localObject1).setImageBitmap((Bitmap)localObject2);
            }
            ((ImageView)localObject1).setVisibility(0);
          }
          else if (i == 1)
          {
            ((TextView)localObject2).setVisibility(8);
            localObject2 = AVGameUtil.c("avgame_ranking2@2x.png");
            if (localObject2 != null) {
              ((ImageView)localObject1).setImageBitmap((Bitmap)localObject2);
            }
            ((ImageView)localObject1).setVisibility(0);
          }
          else if (i == 2)
          {
            ((TextView)localObject2).setVisibility(8);
            localObject2 = AVGameUtil.c("avgame_ranking3@2x.png");
            if (localObject2 != null) {
              ((ImageView)localObject1).setImageBitmap((Bitmap)localObject2);
            }
            ((ImageView)localObject1).setVisibility(0);
          }
          this.b.addView(localView);
        }
        catch (Exception localException)
        {
          label375:
          break label375;
        }
        QLog.e("AVGamePosterView", 2, "onGetGameRankingListSuc exception!");
        i += 1;
      }
      return true;
    }
    else
    {
      return false;
    }
  }
  
  public boolean a(String paramString)
  {
    return c(paramString);
  }
  
  public String b()
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
  
  public void b(String paramString)
  {
    UiThreadUtil.a(new AVGamePosterView.1(this, paramString));
  }
  
  public void setContentAndTitleView(int paramInt)
  {
    String str = "avgame_poster_content_bg@2x.png";
    if (paramInt != 2)
    {
      if (paramInt != 4)
      {
        if (paramInt != 5)
        {
          localObject = null;
        }
        else
        {
          localObject = "avgame_poster_knowledge_title@2x.png";
          str = "avgame_knowledge_poster_content_bg@2x.png";
        }
      }
      else
      {
        localObject = "avgame_poster_song_title@2x.png";
        str = "avgame_song_poster_content_bg@2x.png";
      }
    }
    else {
      localObject = "avgame_poster_mosaic_title@2x.png";
    }
    Object localObject = AVGameUtil.c((String)localObject);
    if (localObject != null) {
      this.a.setImageBitmap((Bitmap)localObject);
    }
    localObject = AVGameUtil.c(str);
    if (localObject != null) {
      this.c.setImageDrawable(new BitmapDrawable((Bitmap)localObject));
    }
  }
  
  public void setPresenter(IGamePosterView paramIGamePosterView)
  {
    this.d = paramIGamePosterView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGamePosterView
 * JD-Core Version:    0.7.0.1
 */