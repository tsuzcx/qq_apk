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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.xmlpull.v1.XmlSerializer;

public class bcif
  extends bcgw
{
  public View.OnClickListener a;
  public String ac;
  public String ad;
  public String ae;
  public String af;
  public String ag;
  public String ah;
  public int o;
  public int p;
  public int q = 1;
  
  public bcif()
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new bcih(this);
    this.jdField_a_of_type_JavaLangString = "live";
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    LinearLayout localLinearLayout = null;
    Resources localResources = paramContext.getResources();
    if ((paramView != null) && ((paramView instanceof LinearLayout)))
    {
      paramView = paramView.getTag();
      if ((paramView == null) || (!(paramView instanceof bcii))) {}
    }
    for (paramView = (bcii)paramView;; paramView = null)
    {
      paramBundle = paramView;
      if (paramView == null)
      {
        paramBundle = new bcii();
        localLinearLayout = new LinearLayout(paramContext);
        localLinearLayout.setOrientation(1);
        localLinearLayout.setGravity(17);
        paramView = new LinearLayout.LayoutParams(-2, -2);
        paramView.gravity = 1;
        paramView.setMargins(0, AIOUtils.dp2px(10.0F, localResources), 0, AIOUtils.dp2px(20.0F, localResources));
        localLinearLayout.setLayoutParams(paramView);
        paramView = new NowVideoLayout(paramContext);
        Object localObject = new LinearLayout.LayoutParams(-2, -2);
        paramView.setId(2131377869);
        paramBundle.jdField_a_of_type_ComTencentBizNowNowVideoLayout = paramView;
        localLinearLayout.addView(paramView, (ViewGroup.LayoutParams)localObject);
        paramView = new LinearLayout(paramContext);
        paramView.setOrientation(1);
        localObject = new LinearLayout.LayoutParams(AIOUtils.dp2px(156.0F, localResources), -2);
        ((LinearLayout.LayoutParams)localObject).setMargins(0, 0, 0, 0);
        paramView.setPadding(AIOUtils.dp2px(7.0F, localResources), AIOUtils.dp2px(8.0F, localResources), AIOUtils.dp2px(7.0F, localResources), AIOUtils.dp2px(8.0F, localResources));
        paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        paramView.setBackgroundResource(2130843716);
        localLinearLayout.addView(paramView);
        localObject = new TextView(paramContext);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
        ((TextView)localObject).setBackgroundColor(localResources.getColor(2131167276));
        ((TextView)localObject).setPadding(0, 0, 0, 0);
        ((TextView)localObject).setTextColor(-16777216);
        ((TextView)localObject).setEllipsize(TextUtils.TruncateAt.END);
        ((TextView)localObject).setTextSize(0, AIOUtils.dp2px(12.0F, localResources));
        ((TextView)localObject).setSingleLine();
        localLayoutParams.setMargins(0, 0, 0, 0);
        paramBundle.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject);
        ((TextView)localObject).setId(2131379873);
        paramView.addView((View)localObject, localLayoutParams);
        paramContext = new TextView(paramContext);
        localObject = new LinearLayout.LayoutParams(-1, -2);
        paramContext.setBackgroundColor(localResources.getColor(2131167276));
        paramContext.setPadding(0, AIOUtils.dp2px(3.0F, localResources), 0, 0);
        paramContext.setTextColor(-16777216);
        paramContext.setEllipsize(TextUtils.TruncateAt.END);
        paramContext.setTextSize(0, AIOUtils.dp2px(12.0F, localResources));
        paramContext.setSingleLine();
        ((LinearLayout.LayoutParams)localObject).setMargins(0, 0, 0, 0);
        paramBundle.b = paramContext;
        paramContext.setId(2131379877);
        paramView.addView(paramContext, (ViewGroup.LayoutParams)localObject);
      }
      localLinearLayout.setTag(paramBundle);
      paramBundle.jdField_a_of_type_ComTencentBizNowNowVideoLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramBundle.jdField_a_of_type_ComTencentBizNowNowVideoLayout.setOnLongClickListener(new bcig(this));
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
    this.ad = paramObjectInput.readUTF();
    this.ae = paramObjectInput.readUTF();
    this.af = paramObjectInput.readUTF();
    this.o = paramObjectInput.readInt();
    this.p = paramObjectInput.readInt();
    this.q = paramObjectInput.readInt();
    this.ag = paramObjectInput.readUTF();
    this.ac = paramObjectInput.readUTF();
    this.ah = paramObjectInput.readUTF();
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    if (this.ad != null)
    {
      str = this.ad;
      paramObjectOutput.writeUTF(str);
      if (this.ae == null) {
        break label156;
      }
      str = this.ae;
      label36:
      paramObjectOutput.writeUTF(str);
      if (this.af == null) {
        break label162;
      }
      str = this.af;
      label55:
      paramObjectOutput.writeUTF(str);
      paramObjectOutput.writeInt(this.o);
      paramObjectOutput.writeInt(this.p);
      paramObjectOutput.writeInt(this.q);
      if (this.ag == null) {
        break label168;
      }
      str = this.ag;
      label104:
      paramObjectOutput.writeUTF(str);
      if (this.ac == null) {
        break label174;
      }
      str = this.ac;
      label123:
      paramObjectOutput.writeUTF(str);
      if (this.ah == null) {
        break label180;
      }
    }
    label156:
    label162:
    label168:
    label174:
    label180:
    for (String str = this.ah;; str = "")
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
    paramXmlSerializer.attribute(null, "cover", this.ad);
    paramXmlSerializer.attribute(null, "src", this.ae);
    paramXmlSerializer.attribute(null, "video_info", this.af);
    paramXmlSerializer.attribute(null, "preWidth", String.valueOf(this.o));
    paramXmlSerializer.attribute(null, "preHeight", String.valueOf(this.p));
    paramXmlSerializer.attribute(null, "busiType", String.valueOf(this.q));
    paramXmlSerializer.attribute(null, "recordID", String.valueOf(this.ag));
    paramXmlSerializer.attribute(null, "roomID", String.valueOf(this.ac));
    paramXmlSerializer.attribute(null, "title", String.valueOf(this.ah));
    paramXmlSerializer.endTag(null, "live");
  }
  
  /* Error */
  public boolean a(bcin parambcin)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +5 -> 6
    //   4: iconst_1
    //   5: ireturn
    //   6: aload_0
    //   7: aload_1
    //   8: ldc 227
    //   10: invokevirtual 267	bcin:a	(Ljava/lang/String;)Ljava/lang/String;
    //   13: putfield 186	bcif:ad	Ljava/lang/String;
    //   16: aload_0
    //   17: aload_1
    //   18: ldc 233
    //   20: invokevirtual 267	bcin:a	(Ljava/lang/String;)Ljava/lang/String;
    //   23: putfield 188	bcif:ae	Ljava/lang/String;
    //   26: aload_0
    //   27: aload_1
    //   28: ldc 235
    //   30: invokevirtual 267	bcin:a	(Ljava/lang/String;)Ljava/lang/String;
    //   33: putfield 190	bcif:af	Ljava/lang/String;
    //   36: aload_0
    //   37: aload_1
    //   38: ldc 249
    //   40: invokevirtual 267	bcin:a	(Ljava/lang/String;)Ljava/lang/String;
    //   43: putfield 200	bcif:ag	Ljava/lang/String;
    //   46: aload_0
    //   47: aload_1
    //   48: ldc 254
    //   50: invokevirtual 267	bcin:a	(Ljava/lang/String;)Ljava/lang/String;
    //   53: putfield 202	bcif:ac	Ljava/lang/String;
    //   56: aload_0
    //   57: aload_1
    //   58: ldc_w 256
    //   61: invokevirtual 267	bcin:a	(Ljava/lang/String;)Ljava/lang/String;
    //   64: putfield 204	bcif:ah	Ljava/lang/String;
    //   67: aload_1
    //   68: ldc 237
    //   70: invokevirtual 267	bcin:a	(Ljava/lang/String;)Ljava/lang/String;
    //   73: astore_3
    //   74: aload_3
    //   75: ifnonnull +68 -> 143
    //   78: iconst_0
    //   79: istore_2
    //   80: aload_0
    //   81: iload_2
    //   82: putfield 196	bcif:o	I
    //   85: aload_1
    //   86: ldc 245
    //   88: invokevirtual 267	bcin:a	(Ljava/lang/String;)Ljava/lang/String;
    //   91: astore_3
    //   92: aload_3
    //   93: ifnonnull +82 -> 175
    //   96: iconst_0
    //   97: istore_2
    //   98: aload_0
    //   99: iload_2
    //   100: putfield 198	bcif:p	I
    //   103: aload_1
    //   104: ldc 247
    //   106: invokevirtual 267	bcin:a	(Ljava/lang/String;)Ljava/lang/String;
    //   109: astore_1
    //   110: aload_1
    //   111: ifnonnull +96 -> 207
    //   114: iconst_0
    //   115: istore_2
    //   116: aload_0
    //   117: iload_2
    //   118: putfield 23	bcif:q	I
    //   121: iconst_1
    //   122: ireturn
    //   123: astore_1
    //   124: invokestatic 273	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   127: ifeq -123 -> 4
    //   130: ldc_w 275
    //   133: iconst_2
    //   134: ldc_w 277
    //   137: aload_1
    //   138: invokestatic 281	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   141: iconst_1
    //   142: ireturn
    //   143: aload_3
    //   144: invokestatic 286	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   147: invokevirtual 289	java/lang/Integer:intValue	()I
    //   150: istore_2
    //   151: goto -71 -> 80
    //   154: astore_3
    //   155: invokestatic 273	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   158: ifeq -73 -> 85
    //   161: ldc_w 275
    //   164: iconst_2
    //   165: ldc_w 291
    //   168: aload_3
    //   169: invokestatic 281	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   172: goto -87 -> 85
    //   175: aload_3
    //   176: invokestatic 286	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   179: invokevirtual 289	java/lang/Integer:intValue	()I
    //   182: istore_2
    //   183: goto -85 -> 98
    //   186: astore_3
    //   187: invokestatic 273	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   190: ifeq -87 -> 103
    //   193: ldc_w 275
    //   196: iconst_2
    //   197: ldc_w 293
    //   200: aload_3
    //   201: invokestatic 281	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   204: goto -101 -> 103
    //   207: aload_1
    //   208: invokestatic 286	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   211: invokevirtual 289	java/lang/Integer:intValue	()I
    //   214: istore_2
    //   215: goto -99 -> 116
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	218	0	this	bcif
    //   0	218	1	parambcin	bcin
    //   79	136	2	i	int
    //   73	71	3	str	String
    //   154	22	3	localNumberFormatException1	java.lang.NumberFormatException
    //   186	15	3	localNumberFormatException2	java.lang.NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   103	110	123	java/lang/NumberFormatException
    //   116	121	123	java/lang/NumberFormatException
    //   207	215	123	java/lang/NumberFormatException
    //   67	74	154	java/lang/NumberFormatException
    //   80	85	154	java/lang/NumberFormatException
    //   143	151	154	java/lang/NumberFormatException
    //   85	92	186	java/lang/NumberFormatException
    //   98	103	186	java/lang/NumberFormatException
    //   175	183	186	java/lang/NumberFormatException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcif
 * JD-Core Version:    0.7.0.1
 */