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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle.TitleTextView;
import com.tencent.mobileqq.troop.widget.EllipsizingTextView;
import com.tencent.mobileqq.utils.StringUtil;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.xmlpull.v1.XmlSerializer;

public abstract class bdnw
  extends bdnu
  implements View.OnClickListener
{
  private static int o = 11;
  protected boolean a;
  protected String ac;
  protected String ad;
  protected String ae;
  protected String af;
  protected String ag;
  protected String ah;
  public String ai;
  protected String aj;
  protected String ak;
  protected String al;
  public String am;
  protected boolean b;
  
  public bdnw()
  {
    this.jdField_a_of_type_Int = o;
  }
  
  public bdnw(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Int = o;
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.ai = paramString1;
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
      paramView.setLineSpacing(AIOUtils.dp2px(d() * 1.0F / 2.0F, paramView.getResources()), 1.0F);
      if (paramContext.jdField_a_of_type_Boolean == true) {
        paramView.getPaint().setFlags(8);
      }
      if (paramContext.jdField_b_of_type_Boolean == true) {
        paramView.getPaint().setFlags(16);
      }
      if (paramBundle != null) {
        bool = paramBundle.getBoolean("pre_dialog", false);
      }
      if ((bool) && (!TextUtils.isEmpty(this.am))) {
        paramContext.jdField_a_of_type_JavaLangString = this.am;
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
  public bdnx a(android.content.res.Resources paramResources)
  {
    // Byte code:
    //   0: new 86	bdnx
    //   3: dup
    //   4: invokespecial 211	bdnx:<init>	()V
    //   7: astore_1
    //   8: aload_0
    //   9: getfield 213	bdnw:ad	Ljava/lang/String;
    //   12: invokestatic 155	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   15: ifne +151 -> 166
    //   18: aload_1
    //   19: aload_0
    //   20: getfield 213	bdnw:ad	Ljava/lang/String;
    //   23: invokestatic 219	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   26: putfield 87	bdnx:jdField_a_of_type_Int	I
    //   29: aload_0
    //   30: getfield 221	bdnw:ae	Ljava/lang/String;
    //   33: invokestatic 155	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   36: ifeq +176 -> 212
    //   39: aload_0
    //   40: invokevirtual 224	bdnw:g	()I
    //   43: istore_2
    //   44: aload_1
    //   45: iload_2
    //   46: putfield 102	bdnx:jdField_b_of_type_Int	I
    //   49: aload_0
    //   50: getfield 226	bdnw:aj	Ljava/lang/String;
    //   53: invokestatic 155	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   56: ifeq +167 -> 223
    //   59: iconst_0
    //   60: istore_2
    //   61: aload_1
    //   62: iload_2
    //   63: putfield 228	bdnx:d	I
    //   66: aload_1
    //   67: iconst_0
    //   68: putfield 129	bdnx:jdField_a_of_type_Boolean	Z
    //   71: aload_1
    //   72: getfield 102	bdnx:jdField_b_of_type_Int	I
    //   75: iflt +11 -> 86
    //   78: aload_1
    //   79: getfield 102	bdnx:jdField_b_of_type_Int	I
    //   82: iconst_4
    //   83: if_icmplt +24 -> 107
    //   86: aload_1
    //   87: getfield 102	bdnx:jdField_b_of_type_Int	I
    //   90: iconst_4
    //   91: if_icmpne +152 -> 243
    //   94: aload_1
    //   95: iconst_1
    //   96: putfield 129	bdnx:jdField_a_of_type_Boolean	Z
    //   99: aload_1
    //   100: aload_0
    //   101: invokevirtual 224	bdnw:g	()I
    //   104: putfield 102	bdnx:jdField_b_of_type_Int	I
    //   107: aload_0
    //   108: getfield 230	bdnw:ag	Ljava/lang/String;
    //   111: invokestatic 155	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   114: ifne +145 -> 259
    //   117: aload_1
    //   118: aload_0
    //   119: getfield 230	bdnw:ag	Ljava/lang/String;
    //   122: invokestatic 235	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   125: putfield 109	bdnx:c	I
    //   128: aload_1
    //   129: getfield 109	bdnx:c	I
    //   132: iconst_1
    //   133: if_icmpge +11 -> 144
    //   136: aload_1
    //   137: aload_0
    //   138: invokevirtual 238	bdnw:f	()I
    //   141: putfield 109	bdnx:c	I
    //   144: aload_1
    //   145: aload_1
    //   146: getfield 109	bdnx:c	I
    //   149: iconst_2
    //   150: idiv
    //   151: putfield 109	bdnx:c	I
    //   154: aload_0
    //   155: invokevirtual 240	bdnw:b	()Ljava/lang/String;
    //   158: invokestatic 155	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   161: ifeq +132 -> 293
    //   164: aconst_null
    //   165: areturn
    //   166: aload_0
    //   167: getfield 242	bdnw:ac	Ljava/lang/String;
    //   170: invokestatic 155	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   173: ifeq +28 -> 201
    //   176: aload_0
    //   177: invokevirtual 245	bdnw:e	()I
    //   180: istore_2
    //   181: aload_1
    //   182: iload_2
    //   183: putfield 87	bdnx:jdField_a_of_type_Int	I
    //   186: goto -157 -> 29
    //   189: astore_3
    //   190: aload_1
    //   191: aload_0
    //   192: invokevirtual 245	bdnw:e	()I
    //   195: putfield 87	bdnx:jdField_a_of_type_Int	I
    //   198: goto -169 -> 29
    //   201: aload_0
    //   202: getfield 242	bdnw:ac	Ljava/lang/String;
    //   205: invokestatic 219	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   208: istore_2
    //   209: goto -28 -> 181
    //   212: aload_0
    //   213: getfield 221	bdnw:ae	Ljava/lang/String;
    //   216: invokestatic 235	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   219: istore_2
    //   220: goto -176 -> 44
    //   223: aload_0
    //   224: getfield 226	bdnw:aj	Ljava/lang/String;
    //   227: invokestatic 235	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   230: istore_2
    //   231: goto -170 -> 61
    //   234: astore_3
    //   235: aload_1
    //   236: iconst_0
    //   237: putfield 228	bdnx:d	I
    //   240: goto -174 -> 66
    //   243: aload_1
    //   244: getfield 102	bdnx:jdField_b_of_type_Int	I
    //   247: iconst_5
    //   248: if_icmpne -149 -> 99
    //   251: aload_1
    //   252: iconst_1
    //   253: putfield 139	bdnx:jdField_b_of_type_Boolean	Z
    //   256: goto -157 -> 99
    //   259: aload_0
    //   260: getfield 247	bdnw:af	Ljava/lang/String;
    //   263: invokestatic 155	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   266: ifeq +16 -> 282
    //   269: aload_0
    //   270: invokevirtual 238	bdnw:f	()I
    //   273: istore_2
    //   274: aload_1
    //   275: iload_2
    //   276: putfield 109	bdnx:c	I
    //   279: goto -151 -> 128
    //   282: aload_0
    //   283: getfield 247	bdnw:af	Ljava/lang/String;
    //   286: invokestatic 235	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   289: istore_2
    //   290: goto -16 -> 274
    //   293: aload_1
    //   294: aload_0
    //   295: invokevirtual 240	bdnw:b	()Ljava/lang/String;
    //   298: putfield 156	bdnx:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   301: aload_1
    //   302: aload_0
    //   303: getfield 249	bdnw:ah	Ljava/lang/String;
    //   306: putfield 158	bdnx:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   309: aload_1
    //   310: areturn
    //   311: astore_3
    //   312: goto -263 -> 49
    //   315: astore_3
    //   316: goto -188 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	319	0	this	bdnw
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
      this.ai = bcsc.a(paramObjectInput.readUTF(), false);
    }
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_Int == 2)
        {
          this.ac = bcsc.a(paramObjectInput.readUTF(), false);
          this.ae = bcsc.a(paramObjectInput.readUTF(), false);
          this.af = bcsc.a(paramObjectInput.readUTF(), false);
          this.ai = bcsc.a(paramObjectInput.readUTF(), false);
          return;
        }
        if (this.jdField_a_of_type_Int == 3)
        {
          this.ac = bcsc.a(paramObjectInput.readUTF(), false);
          this.ae = bcsc.a(paramObjectInput.readUTF(), false);
          this.af = bcsc.a(paramObjectInput.readUTF(), false);
          this.ai = bcsc.a(paramObjectInput.readUTF(), false);
          this.ah = bcsc.a(paramObjectInput.readUTF(), false);
          return;
        }
      } while (this.jdField_a_of_type_Int < 4);
      this.ac = bcsc.a(paramObjectInput.readUTF(), false);
      this.ae = bcsc.a(paramObjectInput.readUTF(), false);
      this.af = bcsc.a(paramObjectInput.readUTF(), false);
      this.ai = bcsc.a(paramObjectInput.readUTF(), false);
      this.ah = bcsc.a(paramObjectInput.readUTF(), false);
      this.aj = bcsc.a(paramObjectInput.readUTF(), false);
    } while (this.jdField_a_of_type_Int < 11);
    this.ak = bcsc.a(paramObjectInput.readUTF(), false);
    this.al = bcsc.a(paramObjectInput.readUTF(), false);
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    if (this.jdField_a_of_type_Int == 1) {
      if (this.ai == null)
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
        str = bcsc.a(this.ai, false);
        break;
        if (this.jdField_a_of_type_Int == 2)
        {
          if (this.ac == null)
          {
            str = "";
            paramObjectOutput.writeUTF(str);
            if (this.ae != null) {
              break label128;
            }
            str = "";
            paramObjectOutput.writeUTF(str);
            if (this.af != null) {
              break label136;
            }
            str = "";
            paramObjectOutput.writeUTF(str);
            if (this.ai != null) {
              break label144;
            }
          }
          for (str = "";; str = bcsc.a(this.ai, false))
          {
            paramObjectOutput.writeUTF(str);
            return;
            str = this.ac;
            break;
            str = this.ae;
            break label78;
            str = this.af;
            break label95;
          }
        }
        if (this.jdField_a_of_type_Int == 3)
        {
          if (this.ac == null)
          {
            str = "";
            paramObjectOutput.writeUTF(str);
            if (this.ae != null) {
              break label258;
            }
            str = "";
            paramObjectOutput.writeUTF(str);
            if (this.af != null) {
              break label266;
            }
            str = "";
            paramObjectOutput.writeUTF(str);
            if (this.ai != null) {
              break label274;
            }
            str = "";
            paramObjectOutput.writeUTF(str);
            if (this.ah != null) {
              break label286;
            }
          }
          for (str = "";; str = this.ah)
          {
            paramObjectOutput.writeUTF(str);
            return;
            str = this.ac;
            break;
            str = this.ae;
            break label191;
            str = this.af;
            break label208;
            str = bcsc.a(this.ai, false);
            break label225;
          }
        }
      } while (this.jdField_a_of_type_Int < 4);
      if (this.ac != null) {
        break label448;
      }
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.ae != null) {
        break label456;
      }
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.af != null) {
        break label464;
      }
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.ai != null) {
        break label472;
      }
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.ah != null) {
        break label484;
      }
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.aj != null) {
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
    if (this.ak == null)
    {
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.al != null) {
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
    for (String str = "";; str = this.al)
    {
      paramObjectOutput.writeUTF(str);
      return;
      str = this.ac;
      break;
      str = this.ae;
      break label329;
      str = this.af;
      break label346;
      str = bcsc.a(this.ai, false);
      break label363;
      str = this.ah;
      break label380;
      str = this.aj;
      break label397;
      str = this.ak;
      break label423;
    }
  }
  
  public void a(String paramString)
  {
    if ((paramString == null) || (paramString.equals("")))
    {
      this.ai = paramString;
      return;
    }
    this.ai = StringUtil.ToDBC(paramString);
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, this.jdField_a_of_type_JavaLangString);
    if (this.ai != null)
    {
      if (!TextUtils.isEmpty(this.af)) {
        paramXmlSerializer.attribute(null, "size", this.af);
      }
      if (!TextUtils.isEmpty(this.ac)) {
        paramXmlSerializer.attribute(null, "color", this.ac);
      }
      if (!TextUtils.isEmpty(this.ae)) {
        paramXmlSerializer.attribute(null, "style", this.ae);
      }
      if (!TextUtils.isEmpty(this.ah)) {
        paramXmlSerializer.attribute(null, "html", this.ah);
      }
      if (!TextUtils.isEmpty(this.aj)) {
        paramXmlSerializer.attribute(null, "type", this.aj);
      }
      if (!TextUtils.isEmpty(this.ak)) {
        paramXmlSerializer.attribute(null, "maxLines", this.ak);
      }
      if (!TextUtils.isEmpty(this.al)) {
        paramXmlSerializer.attribute(null, "lineSpace", this.al);
      }
      paramXmlSerializer.text(this.ai);
    }
    paramXmlSerializer.endTag(null, this.jdField_a_of_type_JavaLangString);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean a(bdpl parambdpl)
  {
    if (parambdpl == null) {
      return true;
    }
    this.ac = parambdpl.a("color");
    this.ae = parambdpl.a("style");
    this.af = parambdpl.a("size");
    this.ai = bcsc.a(bdof.a(parambdpl), false);
    this.ah = parambdpl.a("html");
    this.aj = parambdpl.a("type");
    this.ak = parambdpl.a("maxLines");
    this.al = parambdpl.a("lineSpace");
    return true;
  }
  
  public int b()
  {
    if (!TextUtils.isEmpty(this.ak)) {
      try
      {
        int i = Integer.parseInt(this.ak);
        return i;
      }
      catch (Exception localException) {}
    }
    return 2;
  }
  
  public String b()
  {
    if (this.ai == null) {}
    for (String str = "";; str = this.ai)
    {
      this.ai = str;
      return this.ai;
    }
  }
  
  public void b(String paramString)
  {
    this.ad = paramString;
  }
  
  protected abstract int c();
  
  public String c()
  {
    return this.af;
  }
  
  public void c(String paramString)
  {
    this.ag = paramString;
  }
  
  protected int d()
  {
    if (!TextUtils.isEmpty(this.al)) {
      try
      {
        int i = Integer.parseInt(this.al);
        return i;
      }
      catch (Exception localException) {}
    }
    return 0;
  }
  
  public String d()
  {
    return this.ac;
  }
  
  public void d(String paramString)
  {
    this.am = paramString;
  }
  
  public int e()
  {
    return -16777216;
  }
  
  public String e()
  {
    return this.ae;
  }
  
  public void e(String paramString)
  {
    this.ac = paramString;
  }
  
  public int f()
  {
    return 26;
  }
  
  public String f()
  {
    return this.aj;
  }
  
  public void f(String paramString)
  {
    this.af = paramString;
  }
  
  public int g()
  {
    return 0;
  }
  
  public void g(String paramString)
  {
    this.al = paramString;
  }
  
  public void h(String paramString)
  {
    this.ak = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdnw
 * JD-Core Version:    0.7.0.1
 */