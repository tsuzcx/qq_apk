package com.tencent.luggage.wxa.ks;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import com.tencent.luggage.wxa.pc.g;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONException;
import org.json.JSONObject;

public class d
  extends com.tencent.luggage.wxa.kd.d
{
  public static final int CTRL_INDEX = 510;
  public static final String NAME = "updatePositioningContainer";
  
  private void a(View paramView, int paramInt1, int paramInt2)
  {
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(paramView, "x", new float[] { paramView.getX(), -paramInt1 });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(paramView, "y", new float[] { paramView.getY(), -paramInt2 });
    localObjectAnimator1.addUpdateListener(new d.1(this, paramView));
    localObjectAnimator2.addUpdateListener(new d.2(this, paramView));
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.setDuration(1000L);
    localAnimatorSet.setInterpolator(new d.a(this, 0.0F, 0.0F, 0.58F, 1.0F));
    localAnimatorSet.setTarget(paramView);
    localAnimatorSet.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2 });
    localAnimatorSet.start();
  }
  
  protected int a(JSONObject paramJSONObject)
  {
    return paramJSONObject.getInt("containerId");
  }
  
  protected boolean a(com.tencent.luggage.wxa.jx.e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    if (!(paramView instanceof e)) {
      return false;
    }
    int i = g.a(paramJSONObject, "contentOffsetLeft", 0);
    int j = g.a(paramJSONObject, "contentOffsetTop", 0);
    int k = paramJSONObject.optInt("animate", 0);
    parame = (e)paramView;
    try
    {
      if (!paramJSONObject.getBoolean("visible")) {
        break label221;
      }
      paramInt = 0;
    }
    catch (JSONException paramView)
    {
      for (;;)
      {
        continue;
        paramInt = 4;
      }
    }
    parame.setVisibility(paramInt);
    parame = (a)parame.a(a.class);
    o.d("MicroMsg.JsApiUpdatePositioningContainer", "scrollLeft:%d, scrollTop:%d, animation:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
    if (k == 1)
    {
      a(parame, i, j);
    }
    else
    {
      parame.setX(-i);
      parame.setY(-j);
    }
    paramInt = g.a(paramJSONObject, "innerHeight", parame.getHeight());
    i = g.a(paramJSONObject, "innerWidth", parame.getWidth());
    o.d("MicroMsg.JsApiUpdatePositioningContainer", "innerHeight:%d, innerWidth:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    paramView = parame.getLayoutParams();
    paramView.height = paramInt;
    paramView.width = i;
    parame.setLayoutParams(paramView);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ks.d
 * JD-Core Version:    0.7.0.1
 */