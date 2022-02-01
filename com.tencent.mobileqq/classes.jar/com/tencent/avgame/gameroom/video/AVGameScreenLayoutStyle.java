package com.tencent.avgame.gameroom.video;

import android.content.Context;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.gameroom.MemberVideoDisplayInfo;
import java.util.List;

public abstract class AVGameScreenLayoutStyle
{
  protected Context a;
  protected AVGameAppInterface a;
  protected int b;
  
  public AVGameScreenLayoutStyle(Context paramContext, AVGameAppInterface paramAVGameAppInterface)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface = paramAVGameAppInterface;
  }
  
  public static AVGameScreenLayoutStyle a(int paramInt, Context paramContext, AVGameAppInterface paramAVGameAppInterface)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return new AVGameNinePatchScreenLayout(paramContext, paramAVGameAppInterface);
    }
    return new AVGameShowScreenLayout(paramContext, paramAVGameAppInterface);
  }
  
  public void a(AVGameVideoView[] paramArrayOfAVGameVideoView1, AVGameVideoView[] paramArrayOfAVGameVideoView2, int paramInt1, int paramInt2, List<MemberVideoDisplayInfo> paramList) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameScreenLayoutStyle
 * JD-Core Version:    0.7.0.1
 */