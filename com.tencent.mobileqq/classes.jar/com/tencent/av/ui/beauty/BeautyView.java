package com.tencent.av.ui.beauty;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.opengl.effects.BeautyConfig;
import com.tencent.av.ui.BeautyConfigUtil;
import com.tencent.av.ui.FadingHorizontalScrollView;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.TintStateDrawable;
import com.tencent.av.utils.UITools;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;

public class BeautyView
  extends BeautyBaseView
{
  static final Object[][] c;
  VideoAppInterface d;
  final BeautySeekView e;
  final Button f;
  final FadingHorizontalScrollView g;
  final LinearLayout h;
  int i = 0;
  final ArrayList<BeautyView.BeautyItem> j = new ArrayList(12);
  private boolean k = true;
  
  static
  {
    Object[] arrayOfObject1 = { "BEAUTY_SKIN", Integer.valueOf(2131893146), Integer.valueOf(2130842921) };
    Object[] arrayOfObject2 = { "FACE_V", Integer.valueOf(2131893133), Integer.valueOf(2130842915) };
    Object[] arrayOfObject3 = { "MOUTH_SHAPE", Integer.valueOf(2131893139), Integer.valueOf(2130842919) };
    c = new Object[][] { arrayOfObject1, { "FACE_SHAPE_4", Integer.valueOf(2131893130), Integer.valueOf(2130842912) }, { "COLOR_TONE", Integer.valueOf(2131893145), Integer.valueOf(2130842922) }, arrayOfObject2, { "FACE_THIN", Integer.valueOf(2131893132), Integer.valueOf(2130842913) }, { "CHIN", Integer.valueOf(2131893128), Integer.valueOf(2130842911) }, { "ENLARGE_EYE", Integer.valueOf(2131893129), Integer.valueOf(2130842916) }, { "EYE_LIGHTEN", Integer.valueOf(2131893137), Integer.valueOf(2130842917) }, { "NOSE_THIN", Integer.valueOf(2131893142), Integer.valueOf(2130842923) }, arrayOfObject3, { "TOOTH_WHITEN", Integer.valueOf(2131893153), Integer.valueOf(2130842924) } };
  }
  
  public BeautyView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BeautyView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BeautyView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    inflate(paramContext, 2131625778, this);
    this.e = ((BeautySeekView)findViewById(2131429389));
    this.f = ((Button)findViewById(2131429370));
    this.g = ((FadingHorizontalScrollView)findViewById(2131429386));
    this.h = ((LinearLayout)findViewById(2131429385));
    int m = (int)(ImmersiveUtils.getScreenWidth() / 5.6F);
    this.g.setFadingMode(1);
    this.g.setFadingEdgeLength(m / 2);
    this.g.setOverScrollMode(2);
    paramContext = (RelativeLayout.LayoutParams)this.f.getLayoutParams();
    if (paramContext == null)
    {
      paramContext = new RelativeLayout.LayoutParams(m, -2);
    }
    else
    {
      paramContext.width = m;
      paramContext.height = -2;
    }
    this.f.setLayoutParams(paramContext);
    a(this.f, 2131893127, 2130842920, 2131166696, Integer.valueOf(2131429370));
    paramContext = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramContext instanceof VideoAppInterface))
    {
      this.d = ((VideoAppInterface)paramContext);
      boolean bool;
      if (BeautyConfigUtil.d(this.d.getCurrentAccountUin()) == 0) {
        bool = true;
      } else {
        bool = false;
      }
      this.k = bool;
      paramContext = this.d.x();
    }
    else
    {
      paramContext = new BeautyConfig();
    }
    paramInt = 0;
    while (paramInt < c.length)
    {
      paramAttributeSet = new BeautyView.BeautyItem();
      Object localObject = c;
      paramAttributeSet.c = ((String)localObject[paramInt][0]);
      paramAttributeSet.a = ((Integer)localObject[paramInt][1]).intValue();
      paramAttributeSet.b = ((Integer)c[paramInt][2]).intValue();
      paramAttributeSet.d = paramContext.b(paramAttributeSet.c);
      paramAttributeSet.g = paramContext.c(paramAttributeSet.c);
      paramAttributeSet.f = paramInt;
      this.j.add(paramAttributeSet);
      localObject = a(paramAttributeSet);
      paramAttributeSet = new LinearLayout.LayoutParams(Math.max(m, paramAttributeSet.e), -2);
      this.h.addView((View)localObject, paramAttributeSet);
      if (this.i == paramInt) {
        ((View)localObject).setSelected(true);
      } else {
        ((View)localObject).setSelected(false);
      }
      paramInt += 1;
    }
    b();
    this.e.setBeautySeekActionListener(this);
  }
  
  View a(BeautyView.BeautyItem paramBeautyItem)
  {
    Button localButton = new Button(getContext());
    a(localButton, paramBeautyItem.a, paramBeautyItem.b, 2131166695, paramBeautyItem);
    paramBeautyItem.e = ((int)Math.max(UITools.a(localButton), AIOUtils.b(28.0F, getResources())));
    return localButton;
  }
  
  public void a()
  {
    this.i = 0;
    Object localObject = this.d;
    if (localObject != null)
    {
      localObject = ((VideoAppInterface)localObject).x();
      m = 0;
      while (m < this.j.size())
      {
        BeautyView.BeautyItem localBeautyItem = (BeautyView.BeautyItem)this.j.get(m);
        localBeautyItem.d = ((BeautyConfig)localObject).b(localBeautyItem.c);
        m += 1;
      }
    }
    int n = this.h.getChildCount();
    int m = 0;
    while (m < n)
    {
      localObject = this.h.getChildAt(m);
      if (localObject != null) {
        if (m == this.i) {
          ((View)localObject).setSelected(true);
        } else {
          ((View)localObject).setSelected(false);
        }
      }
      m += 1;
    }
    b();
  }
  
  void a(Button paramButton, int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    Resources localResources = getResources();
    Drawable localDrawable = localResources.getDrawable(paramInt2);
    TintStateDrawable localTintStateDrawable = TintStateDrawable.a(localResources, paramInt2, paramInt3);
    localTintStateDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    paramButton.setCompoundDrawables(null, localTintStateDrawable, null, null);
    paramButton.setTextColor(localResources.getColorStateList(paramInt3));
    paramButton.setText(paramInt1);
    paramButton.setBackgroundDrawable(null);
    paramButton.setOnClickListener(this);
    paramButton.setTag(2131439677, paramObject);
    paramButton.setTextSize(ViewUtils.pxTosp(AIOUtils.b(12.0F, getResources())));
    paramButton.setCompoundDrawablePadding(AIOUtils.b(8.0F, getResources()));
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if (paramString == null) {
      return;
    }
    VideoAppInterface localVideoAppInterface = null;
    Iterator localIterator = this.j.iterator();
    Object localObject;
    do
    {
      localObject = localVideoAppInterface;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = (BeautyView.BeautyItem)localIterator.next();
    } while (!paramString.equals(((BeautyView.BeautyItem)localObject).c));
    if ((localObject != null) && (paramInt1 != 1))
    {
      if (paramInt1 != 2)
      {
        if (paramInt1 != 3) {
          return;
        }
        ((BeautyView.BeautyItem)localObject).d = paramInt2;
        localVideoAppInterface = this.d;
        if (localVideoAppInterface != null) {
          localVideoAppInterface.a(paramString, paramInt2, true);
        }
        AVUtil.a("0X800A569", ((BeautyView.BeautyItem)localObject).f + 1);
        return;
      }
      ((BeautyView.BeautyItem)localObject).d = paramInt2;
      localObject = this.d;
      if (localObject != null) {
        ((VideoAppInterface)localObject).a(paramString, paramInt2, false);
      }
    }
  }
  
  void b()
  {
    Resources localResources = getResources();
    int m = this.i;
    BeautyView.BeautyItem localBeautyItem;
    if ((m >= 0) && (m < this.j.size())) {
      localBeautyItem = (BeautyView.BeautyItem)this.j.get(this.i);
    } else {
      localBeautyItem = null;
    }
    if (localBeautyItem != null) {
      this.e.a(localResources.getString(localBeautyItem.a), localBeautyItem.c, localBeautyItem.d, localBeautyItem.g);
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (paramView == this.f)
    {
      if (this.k)
      {
        this.k = false;
        localObject = this.d;
        if (localObject != null) {
          BeautyConfigUtil.a(((VideoAppInterface)localObject).getCurrentAccountUin(), 1);
        }
        DialogUtil.a((Activity)getContext(), getResources().getString(2131893143), 2131887648, 2131892267, new BeautyView.1(this), new BeautyView.2(this)).show();
      }
      else
      {
        localObject = this.d;
        if (localObject != null)
        {
          ((VideoAppInterface)localObject).y();
          localObject = this.j.iterator();
          while (((Iterator)localObject).hasNext())
          {
            BeautyView.BeautyItem localBeautyItem = (BeautyView.BeautyItem)((Iterator)localObject).next();
            localBeautyItem.d = this.d.n(localBeautyItem.c);
          }
        }
        b();
      }
    }
    else
    {
      localObject = paramView.getTag(2131439677);
      if ((localObject instanceof BeautyView.BeautyItem))
      {
        localObject = (BeautyView.BeautyItem)localObject;
        int m = ((BeautyView.BeautyItem)localObject).f;
        int n = this.i;
        if (m != n)
        {
          if ((n >= 0) && (n < this.h.getChildCount())) {
            this.h.getChildAt(this.i).setSelected(false);
          }
          paramView.setSelected(true);
          this.i = ((BeautyView.BeautyItem)localObject).f;
          b();
        }
        AVUtil.a("0X800A568", ((BeautyView.BeautyItem)localObject).f + 1);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setAppInterface(VideoAppInterface paramVideoAppInterface)
  {
    super.setAppInterface(paramVideoAppInterface);
    paramVideoAppInterface = this.d;
    if (paramVideoAppInterface != null)
    {
      boolean bool;
      if (BeautyConfigUtil.d(paramVideoAppInterface.getCurrentAccountUin()) == 0) {
        bool = true;
      } else {
        bool = false;
      }
      this.k = bool;
      paramVideoAppInterface = this.d.x();
      Iterator localIterator = this.j.iterator();
      while (localIterator.hasNext())
      {
        BeautyView.BeautyItem localBeautyItem = (BeautyView.BeautyItem)localIterator.next();
        if (localBeautyItem != null) {
          localBeautyItem.d = paramVideoAppInterface.b(localBeautyItem.c);
        }
      }
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.beauty.BeautyView
 * JD-Core Version:    0.7.0.1
 */