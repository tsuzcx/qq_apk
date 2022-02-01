package com.tencent.mobileqq.apollo.utils.api.impl;

import com.tencent.mobileqq.apollo.utils.api.IApolloEngineHelper;
import com.tencent.mobileqq.cmshow.engine.CMShowPlatform;
import com.tencent.mobileqq.cmshow.engine.scene.Scene;

public class ApolloEngineHelperImpl
  implements IApolloEngineHelper
{
  public boolean isEngineReady()
  {
    return CMShowPlatform.a.a(Scene.MEME_PLAYER);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.api.impl.ApolloEngineHelperImpl
 * JD-Core Version:    0.7.0.1
 */