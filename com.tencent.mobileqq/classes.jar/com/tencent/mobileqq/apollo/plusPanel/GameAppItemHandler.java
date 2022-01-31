package com.tencent.mobileqq.apollo.plusPanel;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.utils.VipUtils;

public class GameAppItemHandler
  extends AppItemHandler
{
  private Context jdField_a_of_type_AndroidContentContext;
  private ApolloGameData jdField_a_of_type_ComTencentMobileqqDataApolloGameData;
  
  public GameAppItemHandler(Context paramContext, ApolloGameData paramApolloGameData)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqDataApolloGameData = paramApolloGameData;
  }
  
  public Drawable a()
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mPlayGifImage = false;
    return URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqDataApolloGameData.logoUrl, localURLDrawableOptions);
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataApolloGameData.name;
  }
  
  public void a()
  {
    CmGameStartChecker.StartCheckParam localStartCheckParam = new CmGameStartChecker.StartCheckParam(this.jdField_a_of_type_ComTencentMobileqqDataApolloGameData.gameId, false, "check", 0L, 4, 1, 0, 0, "", 226);
    ApolloGameUtil.a(this.jdField_a_of_type_AndroidContentContext, localStartCheckParam);
    VipUtils.a(CmGameUtil.a(), "cmshow", "Apollo", "clickgame", 0, 0, new String[] { "" + this.jdField_a_of_type_ComTencentMobileqqDataApolloGameData.gameId });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.plusPanel.GameAppItemHandler
 * JD-Core Version:    0.7.0.1
 */