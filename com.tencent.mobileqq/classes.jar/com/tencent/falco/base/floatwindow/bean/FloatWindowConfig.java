package com.tencent.falco.base.floatwindow.bean;

import android.graphics.Point;
import android.view.View;
import com.tencent.falco.base.floatwindow.animmanager.FWActivityDefaultAnimator;
import com.tencent.falco.base.floatwindow.animmanager.FWAppDefaultAnimator;
import com.tencent.falco.base.floatwindow.interfaces.OnActivityFloatWindowAnimator;
import com.tencent.falco.base.floatwindow.interfaces.OnAppFloatWindowAnimator;
import com.tencent.falco.base.floatwindow.interfaces.OnDisplayHeight;
import com.tencent.falco.base.floatwindow.interfaces.OnFloatWindowCallbacks;
import com.tencent.falco.base.floatwindow.interfaces.OnInvokeView;
import com.tencent.falco.base.floatwindow.utils.FWDefaultDisplayHeight;
import java.util.ArrayList;
import org.jetbrains.annotations.Nullable;

public class FloatWindowConfig
{
  public static final int ILLEGAL_LAYOUT_ID = -1;
  @Nullable
  public OnActivityFloatWindowAnimator activityFloatAnimator = new FWActivityDefaultAnimator();
  public OnAppFloatWindowAnimator appFloatAnimator = new FWAppDefaultAnimator();
  @Nullable
  public OnFloatWindowCallbacks callbacks = null;
  public String currentActivityName = "";
  public OnDisplayHeight displayHeight = new FWDefaultDisplayHeight();
  public boolean dragEnable = true;
  public ArrayList<String> filterList = new ArrayList();
  public boolean filterSelf = false;
  @Nullable
  public String floatTag = null;
  public int gravity = 0;
  public boolean hasEditText = false;
  public boolean heightMatch = false;
  public float horizontalMargin = 0.0F;
  @Nullable
  public OnInvokeView invokeView = null;
  public boolean isAnim = false;
  public boolean isDrag = false;
  public boolean isShow = false;
  public int layoutId = -1;
  @Nullable
  public View layoutView = null;
  public Point locationPair = new Point(0, 0);
  public Boolean needShow = Boolean.valueOf(true);
  public Point offsetPair = new Point(0, 0);
  public int showPattern = 0;
  public int sidePattern = 0;
  public float verticalMargin = 0.0F;
  public boolean widthMatch = false;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.base.floatwindow.bean.FloatWindowConfig
 * JD-Core Version:    0.7.0.1
 */