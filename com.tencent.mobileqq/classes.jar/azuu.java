import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Html;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle.TitleTextView;
import com.tencent.mobileqq.troop.widget.EllipsizingTextView;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.xmlpull.v1.XmlSerializer;

public abstract class azuu
  extends azus
  implements View.OnClickListener
{
  private static int k = 11;
  protected String S;
  protected String T;
  protected String U;
  protected String V;
  protected String W;
  protected String X;
  public String Y;
  protected String Z;
  protected boolean a;
  protected String aa;
  protected String ab;
  public String ac;
  protected boolean b;
  
  public azuu()
  {
    this.jdField_a_of_type_Int = k;
  }
  
  public azuu(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Int = k;
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.Y = paramString1;
  }
  
  protected TextUtils.TruncateAt a()
  {
    return TextUtils.TruncateAt.END;
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    boolean bool = false;
    if ((paramView != null) && (a().isInstance(paramView)))
    {
      paramView = (TextView)paramView;
      paramView.setTag(this);
      if (!this.jdField_b_of_type_Boolean) {
        break label263;
      }
      paramView.setSingleLine(true);
    }
    for (;;)
    {
      if ((this.jdField_b_of_type_Boolean) || (!this.jdField_a_of_type_Boolean)) {
        paramView.setEllipsize(a());
      }
      paramContext = a(paramContext.getResources());
      if (paramContext == null) {
        break label291;
      }
      paramView.setTextColor(paramContext.jdField_a_of_type_Int);
      paramView.requestLayout();
      paramView.setTypeface(Typeface.DEFAULT, paramContext.jdField_b_of_type_Int);
      paramView.setTextSize(paramContext.c);
      paramView.setLineSpacing(aepi.a(d() * 1.0F / 2.0F, paramView.getResources()), 1.0F);
      if (paramContext.jdField_a_of_type_Boolean == true) {
        paramView.getPaint().setFlags(8);
      }
      if (paramContext.jdField_b_of_type_Boolean == true) {
        paramView.getPaint().setFlags(16);
      }
      if (paramBundle != null) {
        bool = paramBundle.getBoolean("pre_dialog", false);
      }
      if ((bool) && (!TextUtils.isEmpty(this.ac))) {
        paramContext.jdField_a_of_type_JavaLangString = this.ac;
      }
      if ((paramContext.jdField_b_of_type_JavaLangString == null) || (paramContext.jdField_b_of_type_JavaLangString.equals("")) || (!paramContext.jdField_b_of_type_JavaLangString.trim().equals("1"))) {
        break label281;
      }
      paramView.setText(Html.fromHtml(paramContext.jdField_a_of_type_JavaLangString));
      return paramView;
      paramView = a(paramContext);
      paramView.setId(c());
      break;
      label263:
      if (!this.jdField_a_of_type_Boolean) {
        paramView.setMaxLines(b());
      }
    }
    label281:
    paramView.setText(paramContext.jdField_a_of_type_JavaLangString);
    return paramView;
    label291:
    paramView.setText("");
    return paramView;
  }
  
  public TextView a(Context paramContext)
  {
    if (StructMsgItemTitle.TitleTextView.class.isAssignableFrom(a())) {
      return new StructMsgItemTitle.TitleTextView(paramContext);
    }
    return new EllipsizingTextView(paramContext, null);
  }
  
  /* Error */
  public azuv a(android.content.res.Resources paramResources)
  {
    // Byte code:
    //   0: new 85	azuv
    //   3: dup
    //   4: invokespecial 209	azuv:<init>	()V
    //   7: astore_1
    //   8: aload_0
    //   9: getfield 211	azuu:T	Ljava/lang/String;
    //   12: invokestatic 153	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   15: ifne +151 -> 166
    //   18: aload_1
    //   19: aload_0
    //   20: getfield 211	azuu:T	Ljava/lang/String;
    //   23: invokestatic 217	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   26: putfield 86	azuv:jdField_a_of_type_Int	I
    //   29: aload_0
    //   30: getfield 219	azuu:U	Ljava/lang/String;
    //   33: invokestatic 153	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   36: ifeq +176 -> 212
    //   39: aload_0
    //   40: invokevirtual 222	azuu:g	()I
    //   43: istore_2
    //   44: aload_1
    //   45: iload_2
    //   46: putfield 101	azuv:jdField_b_of_type_Int	I
    //   49: aload_0
    //   50: getfield 224	azuu:Z	Ljava/lang/String;
    //   53: invokestatic 153	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   56: ifeq +167 -> 223
    //   59: iconst_0
    //   60: istore_2
    //   61: aload_1
    //   62: iload_2
    //   63: putfield 226	azuv:d	I
    //   66: aload_1
    //   67: iconst_0
    //   68: putfield 127	azuv:jdField_a_of_type_Boolean	Z
    //   71: aload_1
    //   72: getfield 101	azuv:jdField_b_of_type_Int	I
    //   75: iflt +11 -> 86
    //   78: aload_1
    //   79: getfield 101	azuv:jdField_b_of_type_Int	I
    //   82: iconst_4
    //   83: if_icmplt +24 -> 107
    //   86: aload_1
    //   87: getfield 101	azuv:jdField_b_of_type_Int	I
    //   90: iconst_4
    //   91: if_icmpne +152 -> 243
    //   94: aload_1
    //   95: iconst_1
    //   96: putfield 127	azuv:jdField_a_of_type_Boolean	Z
    //   99: aload_1
    //   100: aload_0
    //   101: invokevirtual 222	azuu:g	()I
    //   104: putfield 101	azuv:jdField_b_of_type_Int	I
    //   107: aload_0
    //   108: getfield 228	azuu:W	Ljava/lang/String;
    //   111: invokestatic 153	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   114: ifne +145 -> 259
    //   117: aload_1
    //   118: aload_0
    //   119: getfield 228	azuu:W	Ljava/lang/String;
    //   122: invokestatic 233	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   125: putfield 108	azuv:c	I
    //   128: aload_1
    //   129: getfield 108	azuv:c	I
    //   132: iconst_1
    //   133: if_icmpge +11 -> 144
    //   136: aload_1
    //   137: aload_0
    //   138: invokevirtual 236	azuu:f	()I
    //   141: putfield 108	azuv:c	I
    //   144: aload_1
    //   145: aload_1
    //   146: getfield 108	azuv:c	I
    //   149: iconst_2
    //   150: idiv
    //   151: putfield 108	azuv:c	I
    //   154: aload_0
    //   155: invokevirtual 238	azuu:b	()Ljava/lang/String;
    //   158: invokestatic 153	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   161: ifeq +132 -> 293
    //   164: aconst_null
    //   165: areturn
    //   166: aload_0
    //   167: getfield 240	azuu:S	Ljava/lang/String;
    //   170: invokestatic 153	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   173: ifeq +28 -> 201
    //   176: aload_0
    //   177: invokevirtual 243	azuu:e	()I
    //   180: istore_2
    //   181: aload_1
    //   182: iload_2
    //   183: putfield 86	azuv:jdField_a_of_type_Int	I
    //   186: goto -157 -> 29
    //   189: astore_3
    //   190: aload_1
    //   191: aload_0
    //   192: invokevirtual 243	azuu:e	()I
    //   195: putfield 86	azuv:jdField_a_of_type_Int	I
    //   198: goto -169 -> 29
    //   201: aload_0
    //   202: getfield 240	azuu:S	Ljava/lang/String;
    //   205: invokestatic 217	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   208: istore_2
    //   209: goto -28 -> 181
    //   212: aload_0
    //   213: getfield 219	azuu:U	Ljava/lang/String;
    //   216: invokestatic 233	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   219: istore_2
    //   220: goto -176 -> 44
    //   223: aload_0
    //   224: getfield 224	azuu:Z	Ljava/lang/String;
    //   227: invokestatic 233	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   230: istore_2
    //   231: goto -170 -> 61
    //   234: astore_3
    //   235: aload_1
    //   236: iconst_0
    //   237: putfield 226	azuv:d	I
    //   240: goto -174 -> 66
    //   243: aload_1
    //   244: getfield 101	azuv:jdField_b_of_type_Int	I
    //   247: iconst_5
    //   248: if_icmpne -149 -> 99
    //   251: aload_1
    //   252: iconst_1
    //   253: putfield 137	azuv:jdField_b_of_type_Boolean	Z
    //   256: goto -157 -> 99
    //   259: aload_0
    //   260: getfield 245	azuu:V	Ljava/lang/String;
    //   263: invokestatic 153	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   266: ifeq +16 -> 282
    //   269: aload_0
    //   270: invokevirtual 236	azuu:f	()I
    //   273: istore_2
    //   274: aload_1
    //   275: iload_2
    //   276: putfield 108	azuv:c	I
    //   279: goto -151 -> 128
    //   282: aload_0
    //   283: getfield 245	azuu:V	Ljava/lang/String;
    //   286: invokestatic 233	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   289: istore_2
    //   290: goto -16 -> 274
    //   293: aload_1
    //   294: aload_0
    //   295: invokevirtual 238	azuu:b	()Ljava/lang/String;
    //   298: putfield 154	azuv:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   301: aload_1
    //   302: aload_0
    //   303: getfield 247	azuu:X	Ljava/lang/String;
    //   306: putfield 156	azuv:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   309: aload_1
    //   310: areturn
    //   311: astore_3
    //   312: goto -263 -> 49
    //   315: astore_3
    //   316: goto -188 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	319	0	this	azuu
    //   0	319	1	paramResources	android.content.res.Resources
    //   43	247	2	i	int
    //   189	1	3	localException1	Exception
    //   234	1	3	localException2	Exception
    //   311	1	3	localException3	Exception
    //   315	1	3	localException4	Exception
    // Exception table:
    //   from	to	target	type
    //   8	29	189	java/lang/Exception
    //   166	181	189	java/lang/Exception
    //   181	186	189	java/lang/Exception
    //   201	209	189	java/lang/Exception
    //   49	59	234	java/lang/Exception
    //   61	66	234	java/lang/Exception
    //   223	231	234	java/lang/Exception
    //   29	44	311	java/lang/Exception
    //   44	49	311	java/lang/Exception
    //   212	220	311	java/lang/Exception
    //   107	128	315	java/lang/Exception
    //   259	274	315	java/lang/Exception
    //   274	279	315	java/lang/Exception
    //   282	290	315	java/lang/Exception
  }
  
  protected Class<? extends TextView> a()
  {
    return TextView.class;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    if (this.jdField_a_of_type_Int == 1) {
      this.Y = azah.a(paramObjectInput.readUTF(), false);
    }
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_Int == 2)
        {
          this.S = azah.a(paramObjectInput.readUTF(), false);
          this.U = azah.a(paramObjectInput.readUTF(), false);
          this.V = azah.a(paramObjectInput.readUTF(), false);
          this.Y = azah.a(paramObjectInput.readUTF(), false);
          return;
        }
        if (this.jdField_a_of_type_Int == 3)
        {
          this.S = azah.a(paramObjectInput.readUTF(), false);
          this.U = azah.a(paramObjectInput.readUTF(), false);
          this.V = azah.a(paramObjectInput.readUTF(), false);
          this.Y = azah.a(paramObjectInput.readUTF(), false);
          this.X = azah.a(paramObjectInput.readUTF(), false);
          return;
        }
      } while (this.jdField_a_of_type_Int < 4);
      this.S = azah.a(paramObjectInput.readUTF(), false);
      this.U = azah.a(paramObjectInput.readUTF(), false);
      this.V = azah.a(paramObjectInput.readUTF(), false);
      this.Y = azah.a(paramObjectInput.readUTF(), false);
      this.X = azah.a(paramObjectInput.readUTF(), false);
      this.Z = azah.a(paramObjectInput.readUTF(), false);
    } while (this.jdField_a_of_type_Int < 11);
    this.aa = azah.a(paramObjectInput.readUTF(), false);
    this.ab = azah.a(paramObjectInput.readUTF(), false);
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    if (this.jdField_a_of_type_Int == 1) {
      if (this.Y == null)
      {
        str = "";
        paramObjectOutput.writeUTF(str);
      }
    }
    label78:
    label95:
    label225:
    label363:
    label380:
    do
    {
      do
      {
        return;
        str = azah.a(this.Y, false);
        break;
        if (this.jdField_a_of_type_Int == 2)
        {
          if (this.S == null)
          {
            str = "";
            paramObjectOutput.writeUTF(str);
            if (this.U != null) {
              break label128;
            }
            str = "";
            paramObjectOutput.writeUTF(str);
            if (this.V != null) {
              break label136;
            }
            str = "";
            paramObjectOutput.writeUTF(str);
            if (this.Y != null) {
              break label144;
            }
          }
          for (str = "";; str = azah.a(this.Y, false))
          {
            paramObjectOutput.writeUTF(str);
            return;
            str = this.S;
            break;
            str = this.U;
            break label78;
            str = this.V;
            break label95;
          }
        }
        if (this.jdField_a_of_type_Int == 3)
        {
          if (this.S == null)
          {
            str = "";
            paramObjectOutput.writeUTF(str);
            if (this.U != null) {
              break label258;
            }
            str = "";
            paramObjectOutput.writeUTF(str);
            if (this.V != null) {
              break label266;
            }
            str = "";
            paramObjectOutput.writeUTF(str);
            if (this.Y != null) {
              break label274;
            }
            str = "";
            paramObjectOutput.writeUTF(str);
            if (this.X != null) {
              break label286;
            }
          }
          for (str = "";; str = this.X)
          {
            paramObjectOutput.writeUTF(str);
            return;
            str = this.S;
            break;
            str = this.U;
            break label191;
            str = this.V;
            break label208;
            str = azah.a(this.Y, false);
            break label225;
          }
        }
      } while (this.jdField_a_of_type_Int < 4);
      if (this.S != null) {
        break label448;
      }
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.U != null) {
        break label456;
      }
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.V != null) {
        break label464;
      }
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.Y != null) {
        break label472;
      }
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.X != null) {
        break label484;
      }
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.Z != null) {
        break label492;
      }
      str = "";
      paramObjectOutput.writeUTF(str);
    } while (this.jdField_a_of_type_Int < 11);
    label128:
    label136:
    label144:
    label191:
    label208:
    label346:
    if (this.aa == null)
    {
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.ab != null) {
        break label508;
      }
    }
    label258:
    label266:
    label274:
    label286:
    label329:
    label464:
    label472:
    label484:
    label492:
    label508:
    for (String str = "";; str = this.ab)
    {
      paramObjectOutput.writeUTF(str);
      return;
      str = this.S;
      break;
      str = this.U;
      break label329;
      str = this.V;
      break label346;
      str = azah.a(this.Y, false);
      break label363;
      str = this.X;
      break label380;
      str = this.Z;
      break label397;
      str = this.aa;
      break label423;
    }
  }
  
  public void a(String paramString)
  {
    if ((paramString == null) || (paramString.equals("")))
    {
      this.Y = paramString;
      return;
    }
    this.Y = bdnn.f(paramString);
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, this.jdField_a_of_type_JavaLangString);
    if (this.Y != null)
    {
      if (!TextUtils.isEmpty(this.V)) {
        paramXmlSerializer.attribute(null, "size", this.V);
      }
      if (!TextUtils.isEmpty(this.S)) {
        paramXmlSerializer.attribute(null, "color", this.S);
      }
      if (!TextUtils.isEmpty(this.U)) {
        paramXmlSerializer.attribute(null, "style", this.U);
      }
      if (!TextUtils.isEmpty(this.X)) {
        paramXmlSerializer.attribute(null, "html", this.X);
      }
      if (!TextUtils.isEmpty(this.Z)) {
        paramXmlSerializer.attribute(null, "type", this.Z);
      }
      if (!TextUtils.isEmpty(this.aa)) {
        paramXmlSerializer.attribute(null, "maxLines", this.aa);
      }
      if (!TextUtils.isEmpty(this.ab)) {
        paramXmlSerializer.attribute(null, "lineSpace", this.ab);
      }
      paramXmlSerializer.text(this.Y);
    }
    paramXmlSerializer.endTag(null, this.jdField_a_of_type_JavaLangString);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean a(azwj paramazwj)
  {
    if (paramazwj == null) {
      return true;
    }
    this.S = paramazwj.a("color");
    this.U = paramazwj.a("style");
    this.V = paramazwj.a("size");
    this.Y = azah.a(azvd.a(paramazwj), false);
    this.X = paramazwj.a("html");
    this.Z = paramazwj.a("type");
    this.aa = paramazwj.a("maxLines");
    this.ab = paramazwj.a("lineSpace");
    return true;
  }
  
  public int b()
  {
    if (!TextUtils.isEmpty(this.aa)) {
      try
      {
        int i = Integer.parseInt(this.aa);
        return i;
      }
      catch (Exception localException) {}
    }
    return 2;
  }
  
  public String b()
  {
    if (this.Y == null) {}
    for (String str = "";; str = this.Y)
    {
      this.Y = str;
      return this.Y;
    }
  }
  
  public void b(String paramString)
  {
    this.T = paramString;
  }
  
  protected abstract int c();
  
  public String c()
  {
    return this.V;
  }
  
  public void c(String paramString)
  {
    this.W = paramString;
  }
  
  protected int d()
  {
    if (!TextUtils.isEmpty(this.ab)) {
      try
      {
        int i = Integer.parseInt(this.ab);
        return i;
      }
      catch (Exception localException) {}
    }
    return 0;
  }
  
  public String d()
  {
    return this.S;
  }
  
  public void d(String paramString)
  {
    this.ac = paramString;
  }
  
  public int e()
  {
    return -16777216;
  }
  
  public String e()
  {
    return this.U;
  }
  
  public void e(String paramString)
  {
    this.S = paramString;
  }
  
  public int f()
  {
    return 26;
  }
  
  public String f()
  {
    return this.Z;
  }
  
  public void f(String paramString)
  {
    this.V = paramString;
  }
  
  public int g()
  {
    return 0;
  }
  
  public void g(String paramString)
  {
    this.ab = paramString;
  }
  
  public void h(String paramString)
  {
    this.aa = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azuu
 * JD-Core Version:    0.7.0.1
 */