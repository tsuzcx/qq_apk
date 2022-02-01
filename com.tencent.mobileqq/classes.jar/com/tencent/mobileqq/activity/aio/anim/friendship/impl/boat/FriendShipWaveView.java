package com.tencent.mobileqq.activity.aio.anim.friendship.impl.boat;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import com.tencent.mobileqq.surfaceviewaction.action.Action;
import com.tencent.mobileqq.surfaceviewaction.action.DelayAction;
import com.tencent.mobileqq.surfaceviewaction.action.MoveYToAction;
import com.tencent.mobileqq.surfaceviewaction.action.OpacityAction;
import com.tencent.mobileqq.surfaceviewaction.action.SequenceAction;
import com.tencent.mobileqq.surfaceviewaction.gl.ImageButton;
import com.tencent.mobileqq.surfaceviewaction.gl.ImageButton.OnClickListener;
import com.tencent.mobileqq.surfaceviewaction.gl.Node;
import com.tencent.mobileqq.surfaceviewaction.gl.Sprite;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.mobileqq.surfaceviewaction.gl.Texture;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.LinkedList;
import java.util.List;

public class FriendShipWaveView
  extends SpriteGLView
{
  private List<Sprite> A = new LinkedList();
  private Texture B;
  private Texture C;
  private Texture D;
  private Texture E;
  private Texture F;
  private Texture G;
  private Texture H;
  private Texture I;
  private Texture J;
  private Texture K;
  private Texture L;
  public String a = "FriendShipWaveView";
  protected int b;
  protected int c;
  protected Context d;
  Sprite e;
  Sprite f;
  Sprite g;
  Sprite h;
  Sprite i;
  Sprite j;
  Sprite k;
  Sprite l;
  Sprite m;
  Sprite n;
  Sprite o;
  Sprite p;
  Bitmap q;
  ImageButton r;
  ImageButton.OnClickListener s;
  private List<Sprite> y = new LinkedList();
  private List<Sprite> z = new LinkedList();
  
  public FriendShipWaveView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a()
  {
    int i3 = 0;
    int i1 = 0;
    Sprite localSprite;
    while (i1 < 5)
    {
      localSprite = new Sprite();
      localSprite.a(this.B);
      localSprite.a(-localSprite.b / 2.0F + (localSprite.b - 1.0F) * i1, this.c + localSprite.c / 4.0F);
      a(localSprite);
      this.y.add(localSprite);
      i1 += 1;
    }
    d();
    i1 = 0;
    int i2;
    for (;;)
    {
      i2 = i3;
      if (i1 >= 5) {
        break;
      }
      localSprite = new Sprite();
      localSprite.a(this.C);
      localSprite.a(-localSprite.b / 2.0F + (localSprite.b - 1.0F) * i1, this.c + localSprite.c / 4.0F);
      a(localSprite);
      this.z.add(localSprite);
      i1 += 1;
    }
    while (i2 < 5)
    {
      localSprite = new Sprite();
      localSprite.a(this.D);
      localSprite.a(-localSprite.b / 2.0F + (localSprite.b - 1.0F) * i2, this.c + localSprite.c / 4.0F);
      a(localSprite);
      this.A.add(localSprite);
      i2 += 1;
    }
    a(new FriendShipWaveView.1(this));
    b();
    e();
    f();
    g();
    h();
  }
  
  public void a(int paramInt1, int paramInt2, Context paramContext, ImageButton.OnClickListener paramOnClickListener, Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, Bitmap paramBitmap4, Bitmap paramBitmap5, Bitmap paramBitmap6, Bitmap paramBitmap7, Bitmap paramBitmap8, Bitmap paramBitmap9, Bitmap paramBitmap10, Bitmap paramBitmap11, Bitmap paramBitmap12)
  {
    this.d = paramContext;
    this.s = paramOnClickListener;
    this.b = paramInt1;
    this.c = paramInt2;
    this.q = paramBitmap4;
    this.B = new Texture(this, paramBitmap9);
    this.C = new Texture(this, paramBitmap10);
    this.D = new Texture(this, paramBitmap11);
    this.E = new Texture(this, paramBitmap1);
    this.K = new Texture(this, paramBitmap2);
    this.J = new Texture(this, paramBitmap3);
    this.F = new Texture(this, paramBitmap5);
    this.G = new Texture(this, paramBitmap6);
    this.H = new Texture(this, paramBitmap7);
    this.I = new Texture(this, paramBitmap8);
    this.L = new Texture(this, paramBitmap12);
  }
  
  public void b()
  {
    int i1 = 0;
    Sprite localSprite;
    int i2;
    int i3;
    int i4;
    int i5;
    int i6;
    while (i1 < this.y.size())
    {
      localSprite = (Sprite)this.y.get(i1);
      i2 = (int)(this.c + localSprite.c / 2.0F);
      i3 = (int)(this.c + localSprite.c / 2.0F - DisplayUtil.a(this.d, 85.0F));
      i4 = (int)(this.c + localSprite.c / 2.0F - DisplayUtil.a(this.d, 250.0F));
      i5 = (int)(this.c + localSprite.c / 2.0F - DisplayUtil.a(this.d, 220.0F));
      i6 = (int)(this.c + localSprite.c / 2.0F - DisplayUtil.a(this.d, 230.0F));
      localSprite.a(new Action[] { new SequenceAction(new Action[] { new MoveYToAction(1000, i2, i3), new MoveYToAction(700, i3, i4), new MoveYToAction(300, i4, i5), new MoveYToAction(100, i5, i6) }) });
      i1 += 1;
    }
    i1 = 0;
    while (i1 < this.z.size())
    {
      localSprite = (Sprite)this.z.get(i1);
      i2 = (int)(this.c + localSprite.c / 2.0F);
      i3 = (int)(this.c + localSprite.c / 2.0F - DisplayUtil.a(this.d, 70.0F));
      i4 = (int)(this.c + localSprite.c / 2.0F - DisplayUtil.a(this.d, 235.0F));
      i5 = (int)(this.c + localSprite.c / 2.0F - DisplayUtil.a(this.d, 205.0F));
      i6 = (int)(this.c + localSprite.c / 2.0F - DisplayUtil.a(this.d, 215.0F));
      localSprite.a(new Action[] { new SequenceAction(new Action[] { new MoveYToAction(1000, i2, i3), new MoveYToAction(700, i3, i4), new MoveYToAction(300, i4, i5), new MoveYToAction(100, i5, i6) }) });
      i1 += 1;
    }
    i1 = 0;
    while (i1 < this.A.size())
    {
      localSprite = (Sprite)this.A.get(i1);
      i2 = (int)(this.c + localSprite.c / 2.0F);
      i3 = (int)(this.c + localSprite.c / 2.0F - DisplayUtil.a(this.d, 50.0F));
      i4 = (int)(this.c + localSprite.c / 2.0F - DisplayUtil.a(this.d, 215.0F));
      i5 = (int)(this.c + localSprite.c / 2.0F - DisplayUtil.a(this.d, 185.0F));
      i6 = (int)(this.c + localSprite.c / 2.0F - DisplayUtil.a(this.d, 195.0F));
      localSprite.a(new Action[] { new SequenceAction(new Action[] { new MoveYToAction(1000, i2, i3), new MoveYToAction(700, i3, i4), new MoveYToAction(300, i4, i5), new MoveYToAction(100, i5, i6) }) });
      i1 += 1;
    }
  }
  
  public void c()
  {
    int i1 = 0;
    Object localObject;
    while (i1 < this.y.size())
    {
      localObject = (Sprite)this.y.get(i1);
      ((Sprite)localObject).d += DisplayUtil.a(this.d, 2.0F);
      if ((i1 == this.y.size() - 1) && (((Sprite)localObject).d > this.b + ((Sprite)localObject).b / 2.0F))
      {
        ((Sprite)localObject).d = (((Sprite)this.y.get(0)).d - ((Sprite)localObject).b + 1.0F);
        localObject = this.y;
        ((List)localObject).add(0, ((List)localObject).remove(i1));
        break;
      }
      i1 += 1;
    }
    i1 = 0;
    while (i1 < this.z.size())
    {
      localObject = (Sprite)this.z.get(i1);
      ((Sprite)localObject).d += DisplayUtil.a(this.d, 3.0F);
      if ((i1 == this.z.size() - 1) && (((Sprite)localObject).d > this.b + ((Sprite)localObject).b / 2.0F))
      {
        ((Sprite)localObject).d = (((Sprite)this.z.get(0)).d - ((Sprite)localObject).b + 1.0F);
        localObject = this.z;
        ((List)localObject).add(0, ((List)localObject).remove(i1));
        break;
      }
      i1 += 1;
    }
    i1 = 0;
    while (i1 < this.A.size())
    {
      localObject = (Sprite)this.A.get(i1);
      ((Sprite)localObject).d += DisplayUtil.a(this.d, 4.0F);
      if ((i1 == this.A.size() - 1) && (((Sprite)localObject).d > this.b + ((Sprite)localObject).b / 2.0F))
      {
        ((Sprite)localObject).d = (((Sprite)this.A.get(0)).d - ((Sprite)localObject).b + 1.0F);
        localObject = this.A;
        ((List)localObject).add(0, ((List)localObject).remove(i1));
        return;
      }
      i1 += 1;
    }
  }
  
  public void d()
  {
    this.e = new Sprite();
    this.e.a(this.E);
    Object localObject = this.e;
    ((Sprite)localObject).a(this.b / 2, -((Sprite)localObject).c / 2.0F);
    a(this.e);
    localObject = new DelayAction(1100);
    ((DelayAction)localObject).a(new FriendShipWaveView.2(this));
    this.e.a(new Action[] { localObject });
  }
  
  public void e()
  {
    this.g = new Sprite();
    Object localObject = this.g;
    ((Sprite)localObject).f = 0.0F;
    ((Sprite)localObject).a(this.K);
    this.g.a(this.b / 2, DisplayUtil.a(this.d, 165.0F) + this.g.c / 2.0F);
    this.f = new Sprite();
    localObject = this.f;
    ((Sprite)localObject).f = 0.0F;
    ((Sprite)localObject).a(this.L);
    this.f.a(this.b / 2, DisplayUtil.a(this.d, 130.0F) + this.f.c / 2.0F);
    localObject = new DelayAction(1200);
    ((DelayAction)localObject).a(new FriendShipWaveView.3(this));
    a(this.g);
    a(this.f);
    this.g.a(new Action[] { localObject });
  }
  
  public void f()
  {
    this.h = new Sprite();
    this.h.a(this.F);
    Object localObject = this.h;
    ((Sprite)localObject).i = 0;
    ((Sprite)localObject).a(this.b / 2 - DisplayUtil.a(this.d, 110.0F), this.f.e + 20.0F);
    localObject = new DelayAction(1200);
    ((DelayAction)localObject).a(new FriendShipWaveView.4(this));
    a(this.h);
    this.h.a(new Action[] { localObject });
  }
  
  public void g()
  {
    this.l = new Sprite();
    this.l.a(this.J);
    this.l.a(this.h.d - this.h.b / 2.0F - 3.0F, this.h.e - this.h.c / 2.0F);
    this.l.i = 0;
    DelayAction localDelayAction = new DelayAction(1700);
    localDelayAction.a(new FriendShipWaveView.5(this));
    a(this.l);
    this.l.a(new Action[] { localDelayAction });
  }
  
  public void h()
  {
    DelayAction localDelayAction = new DelayAction(1000);
    try
    {
      this.r = new ImageButton(this, this.q, true);
      this.r.i = 0;
      if (Build.VERSION.SDK_INT < 19) {
        break label171;
      }
      i1 = ImmersiveUtils.getStatusBarHeight(this.d);
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        continue;
        int i1 = 0;
      }
    }
    this.r.a(this.b - DisplayUtil.a(this.d, 20.0F) - this.r.b / 2.0F, DisplayUtil.a(this.d, 5.0F) + this.r.c / 2.0F + i1);
    a(this.r);
    break label139;
    if (QLog.isColorLevel()) {
      QLog.d(this.a, 2, "decode init mCloseButton failed");
    }
    label139:
    localDelayAction.a(new FriendShipWaveView.6(this));
    this.r.a(new Action[] { localDelayAction });
  }
  
  public void i()
  {
    List localList = getNodeList();
    int i1 = 0;
    while (i1 < localList.size())
    {
      ((Node)localList.get(i1)).a(new Action[] { new OpacityAction(300, 255, 0) });
      i1 += 1;
    }
  }
  
  public void j()
  {
    k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.friendship.impl.boat.FriendShipWaveView
 * JD-Core Version:    0.7.0.1
 */