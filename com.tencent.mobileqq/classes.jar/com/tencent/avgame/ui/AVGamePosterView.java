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
  protected LinearLayout a;
  private AVGamePosterCoverView jdField_a_of_type_ComTencentAvgameUiAVGamePosterCoverView;
  private IGamePosterView jdField_a_of_type_ComTencentAvgameUiIGamePosterView;
  private ImageView b;
  private ImageView c;
  private ImageView d;
  
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
  
  private HashMap<String, String> a(UserInfoHandler paramUserInfoHandler, CopyOnWriteArrayList<UserScore> paramCopyOnWriteArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    paramCopyOnWriteArrayList = paramCopyOnWriteArrayList.iterator();
    while (paramCopyOnWriteArrayList.hasNext()) {
      localArrayList.add(String.valueOf(((UserScore)paramCopyOnWriteArrayList.next()).uin));
    }
    return paramUserInfoHandler.a(localArrayList);
  }
  
  private boolean b(String paramString)
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
      this.c.setImageBitmap(paramString);
      return true;
    }
    return false;
  }
  
  public String a()
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
  
  protected void a()
  {
    LayoutInflater.from(getContext()).inflate(2131558662, this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131372976));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131372986));
    this.c = ((ImageView)findViewById(2131372985));
    this.jdField_a_of_type_ComTencentAvgameUiAVGamePosterCoverView = ((AVGamePosterCoverView)findViewById(2131372978));
    this.b = ((ImageView)findViewById(2131372983));
    this.d = ((ImageView)findViewById(2131372984));
    Bitmap localBitmap = AVGameUtil.a("avgame_poster_bg@2x.png");
    if (localBitmap != null) {
      this.d.setImageDrawable(new BitmapDrawable(localBitmap));
    }
    int i = ViewUtils.a(150.0F);
    this.jdField_a_of_type_ComTencentAvgameUiAVGamePosterCoverView.setAsyncClipSize(i, i);
  }
  
  public void a(String paramString)
  {
    UiThreadUtil.a(new AVGamePosterView.1(this, paramString));
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentAvgameUiAVGamePosterCoverView != null)
    {
      if (!TextUtils.isEmpty(paramString1))
      {
        this.jdField_a_of_type_ComTencentAvgameUiAVGamePosterCoverView.setAsyncImage(paramString1);
        return;
      }
      if (paramString2 != null)
      {
        paramString1 = AVGameUtil.a(paramString2);
        if (paramString1 != null) {
          this.jdField_a_of_type_ComTencentAvgameUiAVGamePosterCoverView.setImageBitmap(paramString1);
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
      HashMap localHashMap = a(paramUserInfoHandler, paramCopyOnWriteArrayList);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
      int i = 0;
      while (i < paramCopyOnWriteArrayList.size())
      {
        UserScore localUserScore = (UserScore)paramCopyOnWriteArrayList.get(i);
        try
        {
          View localView = LayoutInflater.from(getContext()).inflate(2131558690, null);
          Object localObject1 = paramUserInfoHandler.a(String.valueOf(localUserScore.uin), (byte)3);
          ((ImageView)localView.findViewById(2131363290)).setImageBitmap((Bitmap)localObject1);
          TextView localTextView = (TextView)localView.findViewById(2131363289);
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
          ((TextView)localView.findViewById(2131363286)).setText(String.valueOf(localUserScore.score));
          localObject2 = (TextView)localView.findViewById(2131363269);
          ((TextView)localObject2).setText(String.valueOf(i + 1));
          localObject1 = (ImageView)localView.findViewById(2131363270);
          if (i == 0)
          {
            ((TextView)localObject2).setVisibility(8);
            localObject2 = AVGameUtil.a("avgame_ranking1@2x.png");
            if (localObject2 != null) {
              ((ImageView)localObject1).setImageBitmap((Bitmap)localObject2);
            }
            ((ImageView)localObject1).setVisibility(0);
          }
          else if (i == 1)
          {
            ((TextView)localObject2).setVisibility(8);
            localObject2 = AVGameUtil.a("avgame_ranking2@2x.png");
            if (localObject2 != null) {
              ((ImageView)localObject1).setImageBitmap((Bitmap)localObject2);
            }
            ((ImageView)localObject1).setVisibility(0);
          }
          else if (i == 2)
          {
            ((TextView)localObject2).setVisibility(8);
            localObject2 = AVGameUtil.a("avgame_ranking3@2x.png");
            if (localObject2 != null) {
              ((ImageView)localObject1).setImageBitmap((Bitmap)localObject2);
            }
            ((ImageView)localObject1).setVisibility(0);
          }
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
        }
        catch (Exception localException)
        {
          label379:
          break label379;
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
    return b(paramString);
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
    Object localObject = AVGameUtil.a((String)localObject);
    if (localObject != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject);
    }
    localObject = AVGameUtil.a(str);
    if (localObject != null) {
      this.b.setImageDrawable(new BitmapDrawable((Bitmap)localObject));
    }
  }
  
  public void setPresenter(IGamePosterView paramIGamePosterView)
  {
    this.jdField_a_of_type_ComTencentAvgameUiIGamePosterView = paramIGamePosterView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGamePosterView
 * JD-Core Version:    0.7.0.1
 */