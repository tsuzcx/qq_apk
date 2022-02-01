import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.JobQueue;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.text.QQText.SmallEmojiSpan.1;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class bdoc
  extends bdoa
{
  boolean b;
  int d;
  public int e;
  public int f;
  
  public bdoc(char[] paramArrayOfChar, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(-1, paramInt, 2);
    this.d = paramInt;
    this.b = paramBoolean1;
    this.a = paramBoolean2;
    paramArrayOfChar = arpm.a(paramArrayOfChar);
    if ((paramArrayOfChar != null) && (paramArrayOfChar.length == 2))
    {
      this.e = paramArrayOfChar[0];
      this.f = paramArrayOfChar[1];
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQText", 2, "mEpId:" + this.e + ",mEId:" + this.f);
    }
  }
  
  private void a()
  {
    QQText.SmallEmojiSpan.1 local1 = new QQText.SmallEmojiSpan.1(this);
    try
    {
      arup localarup = (arup)((QQAppInterface)BaseApplicationImpl.getApplication().getAppRuntime(bdnt.d())).getManager(43);
      if (localarup != null) {
        localarup.a.execute(local1, 128, true);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject = null;
      }
    }
  }
  
  public int a()
  {
    return this.e;
  }
  
  public String a()
  {
    String str = bdnt.c;
    Emoticon localEmoticon = null;
    awmr localawmr = arze.a();
    if (localawmr != null) {
      localEmoticon = localawmr.a(Integer.toString(this.e), Integer.toString(this.f));
    }
    if (localEmoticon != null) {
      str = localEmoticon.character;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQText", 2, "descp:" + str);
    }
    return str;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("tag.vasFont.enlarge", 2, "SmallEmojiSpan setSize size: " + paramInt);
    }
    this.d = paramInt;
    this.b = paramInt;
  }
  
  public void a(EmoticonPackage paramEmoticonPackage)
  {
    if ((!this.a) && (paramEmoticonPackage != null) && (paramEmoticonPackage.isAPNG == 2))
    {
      this.a = true;
      if (QLog.isColorLevel()) {
        QLog.d("QQText", 2, "updateApngFlag mIsAPNG = true");
      }
    }
  }
  
  protected Drawable b()
  {
    Object localObject = new asch(bdnt.d());
    Emoticon localEmoticon = new Emoticon();
    localEmoticon.eId = String.valueOf(this.f);
    localEmoticon.epId = String.valueOf(this.e);
    if (!this.b)
    {
      localEmoticon.jobType = 3;
      ((asch)localObject).a = localEmoticon;
      localObject = ((asch)localObject).a(BaseApplicationImpl.getContext(), BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density);
    }
    for (;;)
    {
      if (localObject != null) {
        ((Drawable)localObject).setBounds(0, 0, this.d, this.d);
      }
      return localObject;
      localEmoticon.jobType = 3;
      ((asch)localObject).a = localEmoticon;
      if (QLog.isColorLevel()) {
        QLog.d("QQText", 2, "SmallEmojiSpan doGetDrawable: epid = " + this.e + " eid = " + this.f + " isAPNG = " + this.a);
      }
      ((asch)localObject).b = this.a;
      localObject = ((asch)localObject).b(BaseApplicationImpl.getContext(), BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density);
      a();
    }
  }
  
  public int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    if (paramFontMetricsInt != null)
    {
      paramFontMetricsInt.ascent = (-this.d);
      paramFontMetricsInt.descent = 0;
      paramFontMetricsInt.top = paramFontMetricsInt.ascent;
      paramFontMetricsInt.bottom = 0;
    }
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdoc
 * JD-Core Version:    0.7.0.1
 */