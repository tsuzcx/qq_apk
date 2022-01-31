import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.now.NowVideoLayout;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.xmlpull.v1.XmlSerializer;

public class axvw
  extends axun
{
  public String S;
  public String T;
  public String U;
  public String V;
  public String W;
  public String X;
  public View.OnClickListener a;
  public int k;
  public int l;
  public int m = 1;
  
  public axvw()
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new axvy(this);
    this.jdField_a_of_type_JavaLangString = "live";
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    LinearLayout localLinearLayout = null;
    Resources localResources = paramContext.getResources();
    if ((paramView != null) && ((paramView instanceof LinearLayout)))
    {
      paramView = paramView.getTag();
      if ((paramView == null) || (!(paramView instanceof axvz))) {}
    }
    for (paramView = (axvz)paramView;; paramView = null)
    {
      paramBundle = paramView;
      if (paramView == null)
      {
        paramBundle = new axvz();
        localLinearLayout = new LinearLayout(paramContext);
        localLinearLayout.setOrientation(1);
        localLinearLayout.setGravity(17);
        paramView = new LinearLayout.LayoutParams(-2, -2);
        paramView.gravity = 1;
        paramView.setMargins(0, actn.a(10.0F, localResources), 0, actn.a(20.0F, localResources));
        localLinearLayout.setLayoutParams(paramView);
        paramView = new NowVideoLayout(paramContext);
        Object localObject = new LinearLayout.LayoutParams(-2, -2);
        paramView.setId(2131376581);
        paramBundle.jdField_a_of_type_ComTencentBizNowNowVideoLayout = paramView;
        localLinearLayout.addView(paramView, (ViewGroup.LayoutParams)localObject);
        paramView = new LinearLayout(paramContext);
        paramView.setOrientation(1);
        localObject = new LinearLayout.LayoutParams(actn.a(156.0F, localResources), -2);
        ((LinearLayout.LayoutParams)localObject).setMargins(0, 0, 0, 0);
        paramView.setPadding(actn.a(7.0F, localResources), actn.a(8.0F, localResources), actn.a(7.0F, localResources), actn.a(8.0F, localResources));
        paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        paramView.setBackgroundResource(2130843077);
        localLinearLayout.addView(paramView);
        localObject = new TextView(paramContext);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
        ((TextView)localObject).setBackgroundColor(localResources.getColor(2131167087));
        ((TextView)localObject).setPadding(0, 0, 0, 0);
        ((TextView)localObject).setTextColor(-16777216);
        ((TextView)localObject).setEllipsize(TextUtils.TruncateAt.END);
        ((TextView)localObject).setTextSize(0, actn.a(12.0F, localResources));
        ((TextView)localObject).setSingleLine();
        localLayoutParams.setMargins(0, 0, 0, 0);
        paramBundle.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject);
        ((TextView)localObject).setId(2131378377);
        paramView.addView((View)localObject, localLayoutParams);
        paramContext = new TextView(paramContext);
        localObject = new LinearLayout.LayoutParams(-1, -2);
        paramContext.setBackgroundColor(localResources.getColor(2131167087));
        paramContext.setPadding(0, actn.a(3.0F, localResources), 0, 0);
        paramContext.setTextColor(-16777216);
        paramContext.setEllipsize(TextUtils.TruncateAt.END);
        paramContext.setTextSize(0, actn.a(12.0F, localResources));
        paramContext.setSingleLine();
        ((LinearLayout.LayoutParams)localObject).setMargins(0, 0, 0, 0);
        paramBundle.b = paramContext;
        paramContext.setId(2131378378);
        paramView.addView(paramContext, (ViewGroup.LayoutParams)localObject);
      }
      localLinearLayout.setTag(paramBundle);
      paramBundle.jdField_a_of_type_ComTencentBizNowNowVideoLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramBundle.jdField_a_of_type_ComTencentBizNowNowVideoLayout.setOnLongClickListener(new axvx(this));
      return localLinearLayout;
    }
  }
  
  public String a()
  {
    return "live";
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.T = paramObjectInput.readUTF();
    this.U = paramObjectInput.readUTF();
    this.V = paramObjectInput.readUTF();
    this.k = paramObjectInput.readInt();
    this.l = paramObjectInput.readInt();
    this.m = paramObjectInput.readInt();
    this.W = paramObjectInput.readUTF();
    this.S = paramObjectInput.readUTF();
    this.X = paramObjectInput.readUTF();
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    if (this.T != null)
    {
      str = this.T;
      paramObjectOutput.writeUTF(str);
      if (this.U == null) {
        break label156;
      }
      str = this.U;
      label36:
      paramObjectOutput.writeUTF(str);
      if (this.V == null) {
        break label162;
      }
      str = this.V;
      label55:
      paramObjectOutput.writeUTF(str);
      paramObjectOutput.writeInt(this.k);
      paramObjectOutput.writeInt(this.l);
      paramObjectOutput.writeInt(this.m);
      if (this.W == null) {
        break label168;
      }
      str = this.W;
      label104:
      paramObjectOutput.writeUTF(str);
      if (this.S == null) {
        break label174;
      }
      str = this.S;
      label123:
      paramObjectOutput.writeUTF(str);
      if (this.X == null) {
        break label180;
      }
    }
    label156:
    label162:
    label168:
    label174:
    label180:
    for (String str = this.X;; str = "")
    {
      paramObjectOutput.writeUTF(str);
      return;
      str = "";
      break;
      str = "";
      break label36;
      str = "";
      break label55;
      str = "";
      break label104;
      str = "";
      break label123;
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "live");
    paramXmlSerializer.attribute(null, "cover", this.T);
    paramXmlSerializer.attribute(null, "src", this.U);
    paramXmlSerializer.attribute(null, "video_info", this.V);
    paramXmlSerializer.attribute(null, "preWidth", String.valueOf(this.k));
    paramXmlSerializer.attribute(null, "preHeight", String.valueOf(this.l));
    paramXmlSerializer.attribute(null, "busiType", String.valueOf(this.m));
    paramXmlSerializer.attribute(null, "recordID", String.valueOf(this.W));
    paramXmlSerializer.attribute(null, "roomID", String.valueOf(this.S));
    paramXmlSerializer.attribute(null, "title", String.valueOf(this.X));
    paramXmlSerializer.endTag(null, "live");
  }
  
  /* Error */
  public boolean a(axwe paramaxwe)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +5 -> 6
    //   4: iconst_1
    //   5: ireturn
    //   6: aload_0
    //   7: aload_1
    //   8: ldc 226
    //   10: invokevirtual 266	axwe:a	(Ljava/lang/String;)Ljava/lang/String;
    //   13: putfield 185	axvw:T	Ljava/lang/String;
    //   16: aload_0
    //   17: aload_1
    //   18: ldc 232
    //   20: invokevirtual 266	axwe:a	(Ljava/lang/String;)Ljava/lang/String;
    //   23: putfield 187	axvw:U	Ljava/lang/String;
    //   26: aload_0
    //   27: aload_1
    //   28: ldc 234
    //   30: invokevirtual 266	axwe:a	(Ljava/lang/String;)Ljava/lang/String;
    //   33: putfield 189	axvw:V	Ljava/lang/String;
    //   36: aload_0
    //   37: aload_1
    //   38: ldc 248
    //   40: invokevirtual 266	axwe:a	(Ljava/lang/String;)Ljava/lang/String;
    //   43: putfield 199	axvw:W	Ljava/lang/String;
    //   46: aload_0
    //   47: aload_1
    //   48: ldc 253
    //   50: invokevirtual 266	axwe:a	(Ljava/lang/String;)Ljava/lang/String;
    //   53: putfield 201	axvw:S	Ljava/lang/String;
    //   56: aload_0
    //   57: aload_1
    //   58: ldc 255
    //   60: invokevirtual 266	axwe:a	(Ljava/lang/String;)Ljava/lang/String;
    //   63: putfield 203	axvw:X	Ljava/lang/String;
    //   66: aload_1
    //   67: ldc 236
    //   69: invokevirtual 266	axwe:a	(Ljava/lang/String;)Ljava/lang/String;
    //   72: astore_3
    //   73: aload_3
    //   74: ifnonnull +68 -> 142
    //   77: iconst_0
    //   78: istore_2
    //   79: aload_0
    //   80: iload_2
    //   81: putfield 195	axvw:k	I
    //   84: aload_1
    //   85: ldc 244
    //   87: invokevirtual 266	axwe:a	(Ljava/lang/String;)Ljava/lang/String;
    //   90: astore_3
    //   91: aload_3
    //   92: ifnonnull +82 -> 174
    //   95: iconst_0
    //   96: istore_2
    //   97: aload_0
    //   98: iload_2
    //   99: putfield 197	axvw:l	I
    //   102: aload_1
    //   103: ldc 246
    //   105: invokevirtual 266	axwe:a	(Ljava/lang/String;)Ljava/lang/String;
    //   108: astore_1
    //   109: aload_1
    //   110: ifnonnull +96 -> 206
    //   113: iconst_0
    //   114: istore_2
    //   115: aload_0
    //   116: iload_2
    //   117: putfield 23	axvw:m	I
    //   120: iconst_1
    //   121: ireturn
    //   122: astore_1
    //   123: invokestatic 272	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   126: ifeq -122 -> 4
    //   129: ldc_w 274
    //   132: iconst_2
    //   133: ldc_w 276
    //   136: aload_1
    //   137: invokestatic 280	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   140: iconst_1
    //   141: ireturn
    //   142: aload_3
    //   143: invokestatic 285	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   146: invokevirtual 288	java/lang/Integer:intValue	()I
    //   149: istore_2
    //   150: goto -71 -> 79
    //   153: astore_3
    //   154: invokestatic 272	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   157: ifeq -73 -> 84
    //   160: ldc_w 274
    //   163: iconst_2
    //   164: ldc_w 290
    //   167: aload_3
    //   168: invokestatic 280	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   171: goto -87 -> 84
    //   174: aload_3
    //   175: invokestatic 285	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   178: invokevirtual 288	java/lang/Integer:intValue	()I
    //   181: istore_2
    //   182: goto -85 -> 97
    //   185: astore_3
    //   186: invokestatic 272	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   189: ifeq -87 -> 102
    //   192: ldc_w 274
    //   195: iconst_2
    //   196: ldc_w 292
    //   199: aload_3
    //   200: invokestatic 280	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   203: goto -101 -> 102
    //   206: aload_1
    //   207: invokestatic 285	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   210: invokevirtual 288	java/lang/Integer:intValue	()I
    //   213: istore_2
    //   214: goto -99 -> 115
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	217	0	this	axvw
    //   0	217	1	paramaxwe	axwe
    //   78	136	2	i	int
    //   72	71	3	str	String
    //   153	22	3	localNumberFormatException1	java.lang.NumberFormatException
    //   185	15	3	localNumberFormatException2	java.lang.NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   102	109	122	java/lang/NumberFormatException
    //   115	120	122	java/lang/NumberFormatException
    //   206	214	122	java/lang/NumberFormatException
    //   66	73	153	java/lang/NumberFormatException
    //   79	84	153	java/lang/NumberFormatException
    //   142	150	153	java/lang/NumberFormatException
    //   84	91	185	java/lang/NumberFormatException
    //   97	102	185	java/lang/NumberFormatException
    //   174	182	185	java/lang/NumberFormatException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axvw
 * JD-Core Version:    0.7.0.1
 */