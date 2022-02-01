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
import bjne;
import com.tencent.avgame.gamelogic.data.UserScore;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import mxz;
import njc;
import njh;
import njs;

public class AVGamePosterView
  extends RelativeLayout
{
  protected ImageView a;
  protected LinearLayout a;
  private AVGamePosterCoverView jdField_a_of_type_ComTencentAvgameUiAVGamePosterCoverView;
  private njc jdField_a_of_type_Njc;
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
  
  private HashMap<String, String> a(mxz parammxz, CopyOnWriteArrayList<UserScore> paramCopyOnWriteArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    paramCopyOnWriteArrayList = paramCopyOnWriteArrayList.iterator();
    while (paramCopyOnWriteArrayList.hasNext()) {
      localArrayList.add(String.valueOf(((UserScore)paramCopyOnWriteArrayList.next()).uin));
    }
    return parammxz.a(localArrayList);
  }
  
  private boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      paramString = njs.a(paramString, 98, -16777216, 0, Bitmap.Config.ARGB_8888);
    } while ((paramString == null) || (paramString.isRecycled()));
    this.c.setImageBitmap(paramString);
    return true;
  }
  
  public String a()
  {
    String str = UUID.randomUUID().toString() + ".png";
    return AppConstants.SDCARD_FILE_SAVE_TMP_PATH + File.separator + str;
  }
  
  protected void a()
  {
    LayoutInflater.from(getContext()).inflate(2131558718, this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131372876));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131372882));
    this.c = ((ImageView)findViewById(2131372881));
    this.jdField_a_of_type_ComTencentAvgameUiAVGamePosterCoverView = ((AVGamePosterCoverView)findViewById(2131372878));
    this.b = ((ImageView)findViewById(2131372879));
    this.d = ((ImageView)findViewById(2131372880));
    Bitmap localBitmap = njh.a("avgame_poster_bg@2x.png");
    if (localBitmap != null) {
      this.d.setImageDrawable(new BitmapDrawable(localBitmap));
    }
    int i = ViewUtils.dip2px(150.0F);
    this.jdField_a_of_type_ComTencentAvgameUiAVGamePosterCoverView.setAsyncClipSize(i, i);
  }
  
  public void a(String paramString)
  {
    bjne.a(new AVGamePosterView.1(this, paramString));
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentAvgameUiAVGamePosterCoverView != null)
    {
      if (TextUtils.isEmpty(paramString1)) {
        break label23;
      }
      this.jdField_a_of_type_ComTencentAvgameUiAVGamePosterCoverView.setAsyncImage(paramString1);
    }
    label23:
    do
    {
      do
      {
        return;
      } while (paramString2 == null);
      paramString1 = njh.a(paramString2);
    } while (paramString1 == null);
    this.jdField_a_of_type_ComTencentAvgameUiAVGamePosterCoverView.setImageBitmap(paramString1);
  }
  
  public boolean a(String paramString)
  {
    return b(paramString);
  }
  
  public boolean a(mxz parammxz, CopyOnWriteArrayList<UserScore> paramCopyOnWriteArrayList)
  {
    if ((parammxz == null) || (paramCopyOnWriteArrayList == null)) {
      return false;
    }
    HashMap localHashMap = a(parammxz, paramCopyOnWriteArrayList);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    int i = 0;
    for (;;)
    {
      if (i < paramCopyOnWriteArrayList.size())
      {
        UserScore localUserScore = (UserScore)paramCopyOnWriteArrayList.get(i);
        for (;;)
        {
          try
          {
            View localView = LayoutInflater.from(getContext()).inflate(2131558733, null);
            Object localObject1 = parammxz.a(String.valueOf(localUserScore.uin), (byte)3);
            ((ImageView)localView.findViewById(2131363225)).setImageBitmap((Bitmap)localObject1);
            TextView localTextView = (TextView)localView.findViewById(2131363224);
            localObject2 = (String)localHashMap.get(String.valueOf(localUserScore.uin));
            localObject1 = localObject2;
            if (TextUtils.isEmpty((CharSequence)localObject2))
            {
              QLog.e("AVGamePosterView", 2, "putUserScores nickName is Empty:" + localUserScore.uin);
              localObject1 = String.valueOf(localUserScore.uin);
            }
            localTextView.setText((CharSequence)localObject1);
            ((TextView)localView.findViewById(2131363222)).setText(String.valueOf(localUserScore.score));
            localObject2 = (TextView)localView.findViewById(2131363216);
            ((TextView)localObject2).setText(String.valueOf(i + 1));
            localObject1 = (ImageView)localView.findViewById(2131363217);
            if (i == 0)
            {
              ((TextView)localObject2).setVisibility(8);
              localObject2 = njh.a("avgame_ranking1@2x.png");
              if (localObject2 != null) {
                ((ImageView)localObject1).setImageBitmap((Bitmap)localObject2);
              }
              ((ImageView)localObject1).setVisibility(0);
              this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
              break;
            }
            if (i == 1)
            {
              ((TextView)localObject2).setVisibility(8);
              localObject2 = njh.a("avgame_ranking2@2x.png");
              if (localObject2 != null) {
                ((ImageView)localObject1).setImageBitmap((Bitmap)localObject2);
              }
              ((ImageView)localObject1).setVisibility(0);
              continue;
            }
            if (i != 2) {
              continue;
            }
          }
          catch (Exception localException)
          {
            QLog.e("AVGamePosterView", 2, "onGetGameRankingListSuc exception!");
          }
          ((TextView)localObject2).setVisibility(8);
          Object localObject2 = njh.a("avgame_ranking3@2x.png");
          if (localObject2 != null) {
            localException.setImageBitmap((Bitmap)localObject2);
          }
          localException.setVisibility(0);
        }
      }
      return true;
      i += 1;
    }
  }
  
  public void setContentAndTitleView(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1;
    switch (paramInt)
    {
    case 3: 
    default: 
      localObject1 = "avgame_poster_content_bg@2x.png";
    }
    for (;;)
    {
      localObject2 = njh.a((String)localObject2);
      if (localObject2 != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject2);
      }
      localObject1 = njh.a((String)localObject1);
      if (localObject1 != null) {
        this.b.setImageDrawable(new BitmapDrawable((Bitmap)localObject1));
      }
      return;
      localObject2 = "avgame_poster_mosaic_title@2x.png";
      localObject1 = "avgame_poster_content_bg@2x.png";
      continue;
      localObject2 = "avgame_poster_song_title@2x.png";
      localObject1 = "avgame_song_poster_content_bg@2x.png";
      continue;
      localObject2 = "avgame_poster_knowledge_title@2x.png";
      localObject1 = "avgame_knowledge_poster_content_bg@2x.png";
    }
  }
  
  public void setPresenter(njc paramnjc)
  {
    this.jdField_a_of_type_Njc = paramnjc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGamePosterView
 * JD-Core Version:    0.7.0.1
 */