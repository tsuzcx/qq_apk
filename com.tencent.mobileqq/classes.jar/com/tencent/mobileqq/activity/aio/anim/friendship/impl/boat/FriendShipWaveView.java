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
  protected int a;
  protected Context a;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  ImageButton.OnClickListener jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlImageButton$OnClickListener;
  ImageButton jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlImageButton;
  Sprite jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite;
  private Texture jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture;
  public String a;
  private List<Sprite> jdField_a_of_type_JavaUtilList = new LinkedList();
  protected int b;
  Sprite jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite;
  private Texture jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlTexture;
  private List<Sprite> jdField_b_of_type_JavaUtilList = new LinkedList();
  Sprite jdField_c_of_type_ComTencentMobileqqSurfaceviewactionGlSprite;
  private Texture jdField_c_of_type_ComTencentMobileqqSurfaceviewactionGlTexture;
  private List<Sprite> jdField_c_of_type_JavaUtilList = new LinkedList();
  Sprite jdField_d_of_type_ComTencentMobileqqSurfaceviewactionGlSprite;
  private Texture jdField_d_of_type_ComTencentMobileqqSurfaceviewactionGlTexture;
  Sprite jdField_e_of_type_ComTencentMobileqqSurfaceviewactionGlSprite;
  private Texture jdField_e_of_type_ComTencentMobileqqSurfaceviewactionGlTexture;
  Sprite jdField_f_of_type_ComTencentMobileqqSurfaceviewactionGlSprite;
  private Texture jdField_f_of_type_ComTencentMobileqqSurfaceviewactionGlTexture;
  Sprite jdField_g_of_type_ComTencentMobileqqSurfaceviewactionGlSprite;
  private Texture jdField_g_of_type_ComTencentMobileqqSurfaceviewactionGlTexture;
  Sprite jdField_h_of_type_ComTencentMobileqqSurfaceviewactionGlSprite;
  private Texture jdField_h_of_type_ComTencentMobileqqSurfaceviewactionGlTexture;
  Sprite jdField_i_of_type_ComTencentMobileqqSurfaceviewactionGlSprite;
  private Texture jdField_i_of_type_ComTencentMobileqqSurfaceviewactionGlTexture;
  Sprite jdField_j_of_type_ComTencentMobileqqSurfaceviewactionGlSprite;
  private Texture jdField_j_of_type_ComTencentMobileqqSurfaceviewactionGlTexture;
  Sprite jdField_k_of_type_ComTencentMobileqqSurfaceviewactionGlSprite;
  private Texture jdField_k_of_type_ComTencentMobileqqSurfaceviewactionGlTexture;
  Sprite l;
  
  public FriendShipWaveView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaLangString = "FriendShipWaveView";
  }
  
  public void a()
  {
    int i1 = 0;
    int m = 0;
    Sprite localSprite;
    while (m < 5)
    {
      localSprite = new Sprite();
      localSprite.a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture);
      localSprite.a(-localSprite.jdField_a_of_type_Float / 2.0F + (localSprite.jdField_a_of_type_Float - 1.0F) * m, this.jdField_b_of_type_Int + localSprite.b / 4.0F);
      a(localSprite);
      this.jdField_a_of_type_JavaUtilList.add(localSprite);
      m += 1;
    }
    d();
    m = 0;
    int n;
    for (;;)
    {
      n = i1;
      if (m >= 5) {
        break;
      }
      localSprite = new Sprite();
      localSprite.a(this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlTexture);
      localSprite.a(-localSprite.jdField_a_of_type_Float / 2.0F + (localSprite.jdField_a_of_type_Float - 1.0F) * m, this.jdField_b_of_type_Int + localSprite.b / 4.0F);
      a(localSprite);
      this.jdField_b_of_type_JavaUtilList.add(localSprite);
      m += 1;
    }
    while (n < 5)
    {
      localSprite = new Sprite();
      localSprite.a(this.jdField_c_of_type_ComTencentMobileqqSurfaceviewactionGlTexture);
      localSprite.a(-localSprite.jdField_a_of_type_Float / 2.0F + (localSprite.jdField_a_of_type_Float - 1.0F) * n, this.jdField_b_of_type_Int + localSprite.b / 4.0F);
      a(localSprite);
      this.jdField_c_of_type_JavaUtilList.add(localSprite);
      n += 1;
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
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlImageButton$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap4;
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture = new Texture(this, paramBitmap9);
    this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlTexture = new Texture(this, paramBitmap10);
    this.jdField_c_of_type_ComTencentMobileqqSurfaceviewactionGlTexture = new Texture(this, paramBitmap11);
    this.jdField_d_of_type_ComTencentMobileqqSurfaceviewactionGlTexture = new Texture(this, paramBitmap1);
    this.j = new Texture(this, paramBitmap2);
    this.i = new Texture(this, paramBitmap3);
    this.e = new Texture(this, paramBitmap5);
    this.f = new Texture(this, paramBitmap6);
    this.g = new Texture(this, paramBitmap7);
    this.jdField_h_of_type_ComTencentMobileqqSurfaceviewactionGlTexture = new Texture(this, paramBitmap8);
    this.k = new Texture(this, paramBitmap12);
  }
  
  public void b()
  {
    int m = 0;
    Sprite localSprite;
    int n;
    int i1;
    int i2;
    int i3;
    int i4;
    while (m < this.jdField_a_of_type_JavaUtilList.size())
    {
      localSprite = (Sprite)this.jdField_a_of_type_JavaUtilList.get(m);
      n = (int)(this.jdField_b_of_type_Int + localSprite.b / 2.0F);
      i1 = (int)(this.jdField_b_of_type_Int + localSprite.b / 2.0F - DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 85.0F));
      i2 = (int)(this.jdField_b_of_type_Int + localSprite.b / 2.0F - DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 250.0F));
      i3 = (int)(this.jdField_b_of_type_Int + localSprite.b / 2.0F - DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 220.0F));
      i4 = (int)(this.jdField_b_of_type_Int + localSprite.b / 2.0F - DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 230.0F));
      localSprite.a(new Action[] { new SequenceAction(new Action[] { new MoveYToAction(1000, n, i1), new MoveYToAction(700, i1, i2), new MoveYToAction(300, i2, i3), new MoveYToAction(100, i3, i4) }) });
      m += 1;
    }
    m = 0;
    while (m < this.jdField_b_of_type_JavaUtilList.size())
    {
      localSprite = (Sprite)this.jdField_b_of_type_JavaUtilList.get(m);
      n = (int)(this.jdField_b_of_type_Int + localSprite.b / 2.0F);
      i1 = (int)(this.jdField_b_of_type_Int + localSprite.b / 2.0F - DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 70.0F));
      i2 = (int)(this.jdField_b_of_type_Int + localSprite.b / 2.0F - DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 235.0F));
      i3 = (int)(this.jdField_b_of_type_Int + localSprite.b / 2.0F - DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 205.0F));
      i4 = (int)(this.jdField_b_of_type_Int + localSprite.b / 2.0F - DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 215.0F));
      localSprite.a(new Action[] { new SequenceAction(new Action[] { new MoveYToAction(1000, n, i1), new MoveYToAction(700, i1, i2), new MoveYToAction(300, i2, i3), new MoveYToAction(100, i3, i4) }) });
      m += 1;
    }
    m = 0;
    while (m < this.jdField_c_of_type_JavaUtilList.size())
    {
      localSprite = (Sprite)this.jdField_c_of_type_JavaUtilList.get(m);
      n = (int)(this.jdField_b_of_type_Int + localSprite.b / 2.0F);
      i1 = (int)(this.jdField_b_of_type_Int + localSprite.b / 2.0F - DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 50.0F));
      i2 = (int)(this.jdField_b_of_type_Int + localSprite.b / 2.0F - DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 215.0F));
      i3 = (int)(this.jdField_b_of_type_Int + localSprite.b / 2.0F - DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 185.0F));
      i4 = (int)(this.jdField_b_of_type_Int + localSprite.b / 2.0F - DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 195.0F));
      localSprite.a(new Action[] { new SequenceAction(new Action[] { new MoveYToAction(1000, n, i1), new MoveYToAction(700, i1, i2), new MoveYToAction(300, i2, i3), new MoveYToAction(100, i3, i4) }) });
      m += 1;
    }
  }
  
  public void c()
  {
    int m = 0;
    Object localObject;
    while (m < this.jdField_a_of_type_JavaUtilList.size())
    {
      localObject = (Sprite)this.jdField_a_of_type_JavaUtilList.get(m);
      ((Sprite)localObject).c += DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 2.0F);
      if ((m == this.jdField_a_of_type_JavaUtilList.size() - 1) && (((Sprite)localObject).c > this.jdField_a_of_type_Int + ((Sprite)localObject).jdField_a_of_type_Float / 2.0F))
      {
        ((Sprite)localObject).c = (((Sprite)this.jdField_a_of_type_JavaUtilList.get(0)).c - ((Sprite)localObject).jdField_a_of_type_Float + 1.0F);
        localObject = this.jdField_a_of_type_JavaUtilList;
        ((List)localObject).add(0, ((List)localObject).remove(m));
        break;
      }
      m += 1;
    }
    m = 0;
    while (m < this.jdField_b_of_type_JavaUtilList.size())
    {
      localObject = (Sprite)this.jdField_b_of_type_JavaUtilList.get(m);
      ((Sprite)localObject).c += DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 3.0F);
      if ((m == this.jdField_b_of_type_JavaUtilList.size() - 1) && (((Sprite)localObject).c > this.jdField_a_of_type_Int + ((Sprite)localObject).jdField_a_of_type_Float / 2.0F))
      {
        ((Sprite)localObject).c = (((Sprite)this.jdField_b_of_type_JavaUtilList.get(0)).c - ((Sprite)localObject).jdField_a_of_type_Float + 1.0F);
        localObject = this.jdField_b_of_type_JavaUtilList;
        ((List)localObject).add(0, ((List)localObject).remove(m));
        break;
      }
      m += 1;
    }
    m = 0;
    while (m < this.jdField_c_of_type_JavaUtilList.size())
    {
      localObject = (Sprite)this.jdField_c_of_type_JavaUtilList.get(m);
      ((Sprite)localObject).c += DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 4.0F);
      if ((m == this.jdField_c_of_type_JavaUtilList.size() - 1) && (((Sprite)localObject).c > this.jdField_a_of_type_Int + ((Sprite)localObject).jdField_a_of_type_Float / 2.0F))
      {
        ((Sprite)localObject).c = (((Sprite)this.jdField_c_of_type_JavaUtilList.get(0)).c - ((Sprite)localObject).jdField_a_of_type_Float + 1.0F);
        localObject = this.jdField_c_of_type_JavaUtilList;
        ((List)localObject).add(0, ((List)localObject).remove(m));
        return;
      }
      m += 1;
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite = new Sprite();
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.a(this.jdField_d_of_type_ComTencentMobileqqSurfaceviewactionGlTexture);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite;
    ((Sprite)localObject).a(this.jdField_a_of_type_Int / 2, -((Sprite)localObject).b / 2.0F);
    a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite);
    localObject = new DelayAction(1100);
    ((DelayAction)localObject).a(new FriendShipWaveView.2(this));
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.a(new Action[] { localObject });
  }
  
  public void e()
  {
    this.jdField_c_of_type_ComTencentMobileqqSurfaceviewactionGlSprite = new Sprite();
    Object localObject = this.jdField_c_of_type_ComTencentMobileqqSurfaceviewactionGlSprite;
    ((Sprite)localObject).e = 0.0F;
    ((Sprite)localObject).a(this.j);
    this.jdField_c_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.a(this.jdField_a_of_type_Int / 2, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 165.0F) + this.jdField_c_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.b / 2.0F);
    this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite = new Sprite();
    localObject = this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite;
    ((Sprite)localObject).e = 0.0F;
    ((Sprite)localObject).a(this.k);
    this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.a(this.jdField_a_of_type_Int / 2, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 130.0F) + this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.b / 2.0F);
    localObject = new DelayAction(1200);
    ((DelayAction)localObject).a(new FriendShipWaveView.3(this));
    a(this.jdField_c_of_type_ComTencentMobileqqSurfaceviewactionGlSprite);
    a(this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite);
    this.jdField_c_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.a(new Action[] { localObject });
  }
  
  public void f()
  {
    this.jdField_d_of_type_ComTencentMobileqqSurfaceviewactionGlSprite = new Sprite();
    this.jdField_d_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.a(this.e);
    Object localObject = this.jdField_d_of_type_ComTencentMobileqqSurfaceviewactionGlSprite;
    ((Sprite)localObject).jdField_a_of_type_Int = 0;
    ((Sprite)localObject).a(this.jdField_a_of_type_Int / 2 - DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 110.0F), this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.d + 20.0F);
    localObject = new DelayAction(1200);
    ((DelayAction)localObject).a(new FriendShipWaveView.4(this));
    a(this.jdField_d_of_type_ComTencentMobileqqSurfaceviewactionGlSprite);
    this.jdField_d_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.a(new Action[] { localObject });
  }
  
  public void g()
  {
    this.jdField_h_of_type_ComTencentMobileqqSurfaceviewactionGlSprite = new Sprite();
    this.jdField_h_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.a(this.i);
    this.jdField_h_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.a(this.jdField_d_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.c - this.jdField_d_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.jdField_a_of_type_Float / 2.0F - 3.0F, this.jdField_d_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.d - this.jdField_d_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.b / 2.0F);
    this.jdField_h_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.jdField_a_of_type_Int = 0;
    DelayAction localDelayAction = new DelayAction(1700);
    localDelayAction.a(new FriendShipWaveView.5(this));
    a(this.jdField_h_of_type_ComTencentMobileqqSurfaceviewactionGlSprite);
    this.jdField_h_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.a(new Action[] { localDelayAction });
  }
  
  public void h()
  {
    DelayAction localDelayAction = new DelayAction(1000);
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlImageButton = new ImageButton(this, this.jdField_a_of_type_AndroidGraphicsBitmap, true);
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlImageButton.jdField_a_of_type_Int = 0;
      if (Build.VERSION.SDK_INT < 19) {
        break label169;
      }
      m = ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidContentContext);
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        continue;
        int m = 0;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlImageButton.a(this.jdField_a_of_type_Int - DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 20.0F) - this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlImageButton.jdField_a_of_type_Float / 2.0F, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 5.0F) + this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlImageButton.b / 2.0F + m);
    a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlImageButton);
    break label137;
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "decode init mCloseButton failed");
    }
    label137:
    localDelayAction.a(new FriendShipWaveView.6(this));
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlImageButton.a(new Action[] { localDelayAction });
  }
  
  public void i()
  {
    List localList = a();
    int m = 0;
    while (m < localList.size())
    {
      ((Node)localList.get(m)).a(new Action[] { new OpacityAction(300, 255, 0) });
      m += 1;
    }
  }
  
  public void j()
  {
    k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.friendship.impl.boat.FriendShipWaveView
 * JD-Core Version:    0.7.0.1
 */