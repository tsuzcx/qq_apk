package com.tencent.common.danmaku.render;

import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;

public class DanmakuViewFactory
{
  public static IDanmakuView a(View paramView)
  {
    if ((paramView instanceof SurfaceView)) {
      return new SurfaceDanmakuView((SurfaceView)paramView);
    }
    if ((paramView instanceof TextureView)) {
      return new TextureDanmakuView((TextureView)paramView);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.danmaku.render.DanmakuViewFactory
 * JD-Core Version:    0.7.0.1
 */