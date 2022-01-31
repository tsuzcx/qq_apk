package com.tencent.mobileqq.activity.aio.qwallet;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.OnCustomizeListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.util.Pair;
import java.util.List;

public class SpecifyRedPkgViewHolder
  extends VipRedPkgViewHolder
{
  private FaceDecoder a;
  
  public SpecifyRedPkgViewHolder(QQAppInterface paramQQAppInterface, QWalletMsgHolder paramQWalletMsgHolder, QQWalletTransferMsgElem paramQQWalletTransferMsgElem, int paramInt, CustomizeStrategyFactory.OnCustomizeListener paramOnCustomizeListener)
  {
    super(paramQQAppInterface, paramQWalletMsgHolder, paramQQWalletTransferMsgElem, paramInt, paramOnCustomizeListener);
  }
  
  /* Error */
  private Pair a(List paramList)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: aload_1
    //   4: ifnull +10 -> 14
    //   7: aload_0
    //   8: getfield 19	com/tencent/mobileqq/activity/aio/qwallet/SpecifyRedPkgViewHolder:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   11: ifnonnull +9 -> 20
    //   14: aconst_null
    //   15: astore 5
    //   17: aload 5
    //   19: areturn
    //   20: aload_1
    //   21: invokeinterface 25 1 0
    //   26: istore_3
    //   27: iload_3
    //   28: anewarray 27	android/graphics/Bitmap
    //   31: astore 6
    //   33: iconst_0
    //   34: istore_2
    //   35: iload_2
    //   36: iload_3
    //   37: if_icmpge +82 -> 119
    //   40: iload_2
    //   41: iconst_5
    //   42: if_icmpge +77 -> 119
    //   45: aload_1
    //   46: iload_2
    //   47: invokeinterface 31 2 0
    //   52: invokestatic 37	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   55: astore 7
    //   57: aload_0
    //   58: getfield 39	com/tencent/mobileqq/activity/aio/qwallet/SpecifyRedPkgViewHolder:jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder	Lcom/tencent/mobileqq/util/FaceDecoder;
    //   61: ifnull +162 -> 223
    //   64: aload_0
    //   65: getfield 39	com/tencent/mobileqq/activity/aio/qwallet/SpecifyRedPkgViewHolder:jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder	Lcom/tencent/mobileqq/util/FaceDecoder;
    //   68: iconst_1
    //   69: aload 7
    //   71: iconst_0
    //   72: iconst_1
    //   73: invokevirtual 44	com/tencent/mobileqq/util/FaceDecoder:a	(ILjava/lang/String;IB)Landroid/graphics/Bitmap;
    //   76: astore 5
    //   78: aload 5
    //   80: ifnonnull +140 -> 220
    //   83: aload_0
    //   84: getfield 39	com/tencent/mobileqq/activity/aio/qwallet/SpecifyRedPkgViewHolder:jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder	Lcom/tencent/mobileqq/util/FaceDecoder;
    //   87: ifnull +21 -> 108
    //   90: aload_0
    //   91: getfield 39	com/tencent/mobileqq/activity/aio/qwallet/SpecifyRedPkgViewHolder:jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder	Lcom/tencent/mobileqq/util/FaceDecoder;
    //   94: aload 7
    //   96: sipush 200
    //   99: iconst_0
    //   100: iconst_1
    //   101: iconst_1
    //   102: iconst_0
    //   103: iconst_1
    //   104: invokevirtual 47	com/tencent/mobileqq/util/FaceDecoder:a	(Ljava/lang/String;IZIZBI)Z
    //   107: pop
    //   108: invokestatic 52	com/tencent/mobileqq/utils/ImageUtil:a	()Landroid/graphics/Bitmap;
    //   111: astore 5
    //   113: iconst_0
    //   114: istore 4
    //   116: goto +113 -> 229
    //   119: invokestatic 58	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   122: invokevirtual 62	com/tencent/common/app/BaseApplicationImpl:getResources	()Landroid/content/res/Resources;
    //   125: ldc 63
    //   127: invokestatic 69	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   130: astore 7
    //   132: new 71	com/tencent/util/Pair
    //   135: dup
    //   136: iload 4
    //   138: invokestatic 76	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   141: aload_0
    //   142: getfield 79	com/tencent/mobileqq/activity/aio/qwallet/SpecifyRedPkgViewHolder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   145: ldc 80
    //   147: invokestatic 85	com/tencent/mobileqq/util/DisplayUtil:a	(Landroid/content/Context;F)I
    //   150: aload 6
    //   152: aload 7
    //   154: fconst_1
    //   155: invokestatic 90	com/tencent/mobileqq/util/PuzzleAvatarUtil:a	(I[Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
    //   158: invokespecial 93	com/tencent/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   161: astore_1
    //   162: aload_1
    //   163: astore 5
    //   165: aload 7
    //   167: ifnull -150 -> 17
    //   170: aload_1
    //   171: astore 5
    //   173: aload 7
    //   175: invokevirtual 97	android/graphics/Bitmap:isRecycled	()Z
    //   178: ifne -161 -> 17
    //   181: aload 7
    //   183: invokevirtual 101	android/graphics/Bitmap:recycle	()V
    //   186: aload_1
    //   187: areturn
    //   188: astore 5
    //   190: aload 5
    //   192: invokevirtual 104	java/lang/Exception:printStackTrace	()V
    //   195: aload_1
    //   196: areturn
    //   197: astore 5
    //   199: aconst_null
    //   200: astore_1
    //   201: aload 5
    //   203: invokevirtual 105	java/lang/OutOfMemoryError:printStackTrace	()V
    //   206: aload_1
    //   207: areturn
    //   208: astore 5
    //   210: goto -9 -> 201
    //   213: astore 5
    //   215: aconst_null
    //   216: astore_1
    //   217: goto -27 -> 190
    //   220: goto +9 -> 229
    //   223: aconst_null
    //   224: astore 5
    //   226: goto -148 -> 78
    //   229: aload 6
    //   231: iload_2
    //   232: aload 5
    //   234: aastore
    //   235: iload_2
    //   236: iconst_1
    //   237: iadd
    //   238: istore_2
    //   239: goto -204 -> 35
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	242	0	this	SpecifyRedPkgViewHolder
    //   0	242	1	paramList	List
    //   34	205	2	i	int
    //   26	12	3	j	int
    //   1	136	4	bool	boolean
    //   15	157	5	localObject1	Object
    //   188	3	5	localException1	Exception
    //   197	5	5	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   208	1	5	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   213	1	5	localException2	Exception
    //   224	9	5	localObject2	Object
    //   31	199	6	arrayOfBitmap	Bitmap[]
    //   55	127	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   173	186	188	java/lang/Exception
    //   27	33	197	java/lang/OutOfMemoryError
    //   45	78	197	java/lang/OutOfMemoryError
    //   83	108	197	java/lang/OutOfMemoryError
    //   108	113	197	java/lang/OutOfMemoryError
    //   119	162	197	java/lang/OutOfMemoryError
    //   173	186	208	java/lang/OutOfMemoryError
    //   27	33	213	java/lang/Exception
    //   45	78	213	java/lang/Exception
    //   83	108	213	java/lang/Exception
    //   108	113	213	java/lang/Exception
    //   119	162	213	java/lang/Exception
  }
  
  private void h()
  {
    int i = 0;
    LinearLayout localLinearLayout = this.jdField_a_of_type_ComTencentMobileqqActivityAioQwalletQWalletMsgHolder.a;
    if ((localLinearLayout == null) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg == null)) {}
    Object localObject2;
    do
    {
      Object localObject4;
      for (;;)
      {
        return;
        int j;
        try
        {
          localObject4 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.specifyUinList;
          if (localObject4 == null) {
            continue;
          }
          j = ((List)localObject4).size();
          if (j <= 0) {
            continue;
          }
          Object localObject1 = (RelativeLayout.LayoutParams)localLinearLayout.getLayoutParams();
          if (j == 1)
          {
            ((RelativeLayout.LayoutParams)localObject1).topMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 38.0F);
            localObject1 = FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(((List)localObject4).get(0)), (byte)3);
            localObject3 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
            ((ImageView)localObject3).setImageDrawable((Drawable)localObject1);
            localLinearLayout.addView((View)localObject3, new LinearLayout.LayoutParams(this.e, this.e));
            return;
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          return;
        }
        if (j != 2) {
          break;
        }
        localException.topMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 46.0F);
        int k = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 24.0F);
        int m = -DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 4.0F);
        while (i < j)
        {
          long l = ((Long)((List)localObject4).get(i)).longValue();
          localObject2 = FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(l), (byte)3);
          localObject3 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
          LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(k, k);
          if (i > 0) {
            localLayoutParams.leftMargin = m;
          }
          localLinearLayout.addView((View)localObject3, i, localLayoutParams);
          ((ImageView)localObject3).setImageDrawable((Drawable)localObject2);
          i += 1;
        }
      }
      ((RelativeLayout.LayoutParams)localObject2).topMargin = this.e;
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.specifyIcon;
      localObject2 = localObject3;
      if (!this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.isLoadFinish)
      {
        if ((localObject3 != null) && (!((Bitmap)localObject3).isRecycled())) {
          ((Bitmap)localObject3).recycle();
        }
        localObject4 = a((List)localObject4);
        localObject2 = localObject3;
        if (localObject4 != null)
        {
          localObject2 = (Bitmap)((Pair)localObject4).second;
          this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.isLoadFinish = ((Boolean)((Pair)localObject4).first).booleanValue();
          this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.specifyIcon = ((Bitmap)((Pair)localObject4).second);
        }
      }
    } while ((localObject2 == null) || (((Bitmap)localObject2).isRecycled()));
    Object localObject3 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject3).setImageBitmap((Bitmap)localObject2);
    localLinearLayout.addView((View)localObject3, new LinearLayout.LayoutParams(this.e, this.e));
  }
  
  public void a(FaceDecoder paramFaceDecoder)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = paramFaceDecoder;
  }
  
  public boolean b()
  {
    boolean bool = super.b();
    if (bool) {
      return bool;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioQwalletQWalletMsgHolder.b.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioQwalletQWalletMsgHolder.b.setTextColor(-8947849);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioQwalletQWalletMsgHolder.b.setText("QQ专享红包");
    return false;
  }
  
  public void d()
  {
    c();
    if (!a()) {
      h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.qwallet.SpecifyRedPkgViewHolder
 * JD-Core Version:    0.7.0.1
 */