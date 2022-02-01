package com.tencent.avgame.gameresult;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.avgame.floatwindow.FloatWindowController;
import com.tencent.avgame.gamelogic.IGameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.SurvivalPkResultInfo;
import com.tencent.avgame.qav.videorecord.SimpleGameRoomStatusListener;
import com.tencent.avgame.ui.IAVGameRootContainer;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;

public class GamePKResultHelper
  extends GameResultBaseHelper
{
  private static final String jdField_a_of_type_JavaLangString = "GamePKResultHelper";
  private final int jdField_a_of_type_Int = 1;
  protected SimpleGameRoomStatusListener a;
  IAVGameRootContainer jdField_a_of_type_ComTencentAvgameUiIAVGameRootContainer;
  private final int b = 2;
  
  public GamePKResultHelper(IAVGameRootContainer paramIAVGameRootContainer)
  {
    this.jdField_a_of_type_ComTencentAvgameQavVideorecordSimpleGameRoomStatusListener = new GamePKResultHelper.1(this);
    this.jdField_a_of_type_ComTencentAvgameUiIAVGameRootContainer = paramIAVGameRootContainer;
  }
  
  public void a()
  {
    Object localObject = IGameEngine.a().a();
    if (((this.jdField_a_of_type_ComTencentAvgameUiIAVGameRootContainer instanceof Activity)) && (!TextUtils.isEmpty(((EngineData)localObject).a().awardUrl)))
    {
      Activity localActivity = (Activity)this.jdField_a_of_type_ComTencentAvgameUiIAVGameRootContainer;
      FloatWindowController.a().c();
      Intent localIntent = new Intent(localActivity, QQBrowserActivity.class);
      String str = ((EngineData)localObject).a().awardUrl;
      int i;
      if (((EngineData)localObject).h()) {
        i = 1;
      } else {
        i = 2;
      }
      str = URLUtil.a(str, "id", ((EngineData)localObject).b());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((EngineData)localObject).c());
      localStringBuilder.append("");
      str = URLUtil.a(str, "type", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(((EngineData)localObject).a());
      localStringBuilder.append("");
      str = URLUtil.a(str, "room", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(((EngineData)localObject).k());
      localStringBuilder.append("");
      str = URLUtil.a(str, "pkid", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(((EngineData)localObject).j());
      localStringBuilder.append("");
      str = URLUtil.a(str, "poolid", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(i);
      localStringBuilder.append("");
      str = URLUtil.a(str, "answer", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(((EngineData)localObject).p());
      localStringBuilder.append("");
      str = URLUtil.a(str, "roundid", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(((EngineData)localObject).r());
      localStringBuilder.append("");
      str = URLUtil.a(str, "businessid", localStringBuilder.toString());
      localObject = str;
      if (URLUtil.a(URLUtil.a(str), "_wv") == null) {
        localObject = URLUtil.a(str, "_wv", "16777217");
      }
      localIntent.putExtra("url", (String)localObject);
      if (QLog.isColorLevel())
      {
        str = jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("jump result url[");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("]");
        QLog.i(str, 2, localStringBuilder.toString());
      }
      localActivity.startActivityForResult(localIntent, 291);
    }
  }
  
  public void b()
  {
    IGameEngine.a().a(this.jdField_a_of_type_ComTencentAvgameQavVideorecordSimpleGameRoomStatusListener);
  }
  
  public void c()
  {
    IGameEngine.a().b(this.jdField_a_of_type_ComTencentAvgameQavVideorecordSimpleGameRoomStatusListener);
  }
  
  public void d()
  {
    IGameEngine.a().a().c();
    IGameEngine.a().l();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameresult.GamePKResultHelper
 * JD-Core Version:    0.7.0.1
 */