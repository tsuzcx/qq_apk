import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.DynamicDrawableSpan;
import android.util.SparseIntArray;
import android.widget.EditText;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.text.QQText.EmoticonSpan;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bgcz
  extends DynamicDrawableSpan
{
  private int jdField_a_of_type_Int = -1;
  private Context jdField_a_of_type_AndroidContentContext;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private bimw jdField_a_of_type_Bimw = new bimw();
  private String jdField_a_of_type_JavaLangString = "";
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString = "";
  private String c = "";
  private String d;
  
  private bgcz(Context paramContext, String paramString1, String paramString2, int paramInt, Paint paramPaint)
  {
    super(0);
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = a(String.format("%s%s", new Object[] { "@", new begq(paramString2, 32).a() }));
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a(paramPaint);
  }
  
  private bgcz(Context paramContext, String paramString1, String paramString2, int paramInt, Paint paramPaint, String paramString3)
  {
    this(paramContext, paramString1, paramString2, paramInt, paramPaint);
    this.d = a(String.format("%s%s", new Object[] { "@", new begq(paramString3, 32).a() }));
  }
  
  public static Spannable a(Spannable paramSpannable, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList)
  {
    if ((paramArrayList == null) || (paramSpannable == null)) {
      return new SpannableStringBuilder();
    }
    paramArrayList.clear();
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramSpannable);
    int m = localSpannableStringBuilder.length();
    bgcz[] arrayOfbgcz = (bgcz[])paramSpannable.getSpans(0, m - 1, bgcz.class);
    if (arrayOfbgcz.length == 0) {
      return localSpannableStringBuilder;
    }
    if (arrayOfbgcz.length > 1) {
      Arrays.sort(arrayOfbgcz, new bgda(paramSpannable));
    }
    int j = 0;
    int i = 0;
    int n;
    int i1;
    for (;;)
    {
      if (i >= arrayOfbgcz.length) {
        break label342;
      }
      bgcz localbgcz = arrayOfbgcz[i];
      n = paramSpannable.getSpanStart(localbgcz) + j;
      i1 = paramSpannable.getSpanEnd(localbgcz) + j;
      String str = localbgcz.jdField_b_of_type_JavaLangString;
      if (!TextUtils.isEmpty(localbgcz.d)) {
        str = localbgcz.d;
      }
      try
      {
        localSpannableStringBuilder.replace(n, i1, str);
        MessageForText.AtTroopMemberInfo localAtTroopMemberInfo = new MessageForText.AtTroopMemberInfo();
        if (localbgcz.jdField_a_of_type_JavaLangString != null)
        {
          localAtTroopMemberInfo.uin = Long.valueOf(localbgcz.jdField_a_of_type_JavaLangString).longValue();
          if (localbgcz.jdField_a_of_type_JavaLangString.equalsIgnoreCase("0")) {
            localAtTroopMemberInfo.flag = 1;
          }
        }
        localAtTroopMemberInfo.startPos = ((short)n);
        localAtTroopMemberInfo.textLen = ((short)str.length());
        paramArrayList.add(localAtTroopMemberInfo);
        k = j + (localAtTroopMemberInfo.textLen - (i1 - n));
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        for (;;)
        {
          int k = j;
          if (QLog.isColorLevel())
          {
            QLog.e("AtTroopMemberSpan", 2, String.format(localSpannableStringBuilder.toString() + ",IndexOutOfBoundsException, convertToSendMsg, start:%d | end:%d | msgBLen:%d", new Object[] { Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(m) }));
            k = j;
          }
        }
      }
      i += 1;
      j = k;
    }
    label342:
    return localSpannableStringBuilder;
  }
  
  public static SpannableString a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, EditText paramEditText)
  {
    if ((paramQQAppInterface == null) || (paramContext == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (paramEditText == null)) {
      return null;
    }
    int i = paramEditText.getWidth();
    int j = paramEditText.getPaddingLeft();
    int k = paramEditText.getPaddingRight();
    try
    {
      paramQQAppInterface = new bgcz(paramContext, paramString2, paramString3, i - j - k, paramEditText.getPaint(), paramString4);
      if (paramQQAppInterface == null) {
        return null;
      }
    }
    catch (OutOfMemoryError paramQQAppInterface)
    {
      for (;;)
      {
        paramQQAppInterface = null;
      }
      paramContext = paramQQAppInterface.jdField_b_of_type_JavaLangString;
      paramString1 = new SpannableString(new begq(paramContext + " ", 16).a());
      paramString1.setSpan(paramQQAppInterface, 0, paramContext.length(), 33);
    }
    return paramString1;
  }
  
  public static SpannableString a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, EditText paramEditText, boolean paramBoolean2)
  {
    return a(paramQQAppInterface, paramContext, paramString1, paramString2, paramString3, paramBoolean1, paramEditText, paramBoolean2, false);
  }
  
  public static SpannableString a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, EditText paramEditText, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((paramQQAppInterface == null) || (paramContext == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (paramEditText == null)) {
      return null;
    }
    bgcz[] arrayOfbgcz = (bgcz[])paramEditText.getEditableText().getSpans(0, paramEditText.getEditableText().toString().length(), bgcz.class);
    int i = paramEditText.getWidth();
    int j = paramEditText.getPaddingLeft();
    int k = paramEditText.getPaddingRight();
    try
    {
      paramQQAppInterface = a(paramQQAppInterface, paramContext, paramString1, paramString2, paramString3, paramBoolean1, i - j - k, paramEditText.getPaint(), paramBoolean2);
      if (paramQQAppInterface == null) {
        return null;
      }
    }
    catch (OutOfMemoryError paramQQAppInterface)
    {
      for (;;)
      {
        paramQQAppInterface = null;
      }
      paramContext = paramQQAppInterface.jdField_b_of_type_JavaLangString;
      paramString1 = new SpannableString(new begq(paramContext + " ", 16).a());
      paramString1.setSpan(paramQQAppInterface, 0, paramContext.length(), 33);
    }
    return paramString1;
  }
  
  public static SpannableString a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramQQAppInterface == null) || (paramContext == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return null;
    }
    try
    {
      paramQQAppInterface = a(paramQQAppInterface, paramContext, paramString1, paramString2, paramString3, paramBoolean1, 400, new Paint(), paramBoolean2);
      if (paramQQAppInterface == null) {
        return null;
      }
    }
    catch (OutOfMemoryError paramQQAppInterface)
    {
      for (;;)
      {
        paramQQAppInterface = null;
      }
      paramContext = paramQQAppInterface.jdField_b_of_type_JavaLangString;
      paramString1 = new SpannableString(paramContext + " ");
      paramString1.setSpan(paramQQAppInterface, 0, paramContext.length(), 33);
    }
    return paramString1;
  }
  
  public static SpannableString a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, String paramString4)
  {
    if ((paramQQAppInterface == null) || (paramContext == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return null;
    }
    try
    {
      paramQQAppInterface = a(paramQQAppInterface, paramContext, paramString1, paramString2, paramString3, paramBoolean1, 400, new Paint(), paramBoolean2);
      if (paramQQAppInterface == null) {
        return null;
      }
    }
    catch (OutOfMemoryError paramQQAppInterface)
    {
      for (;;)
      {
        paramQQAppInterface = null;
      }
      paramContext = paramQQAppInterface.jdField_b_of_type_JavaLangString;
      paramString1 = new SpannableString(paramString4 + paramContext + " ");
      int i = paramString4.length();
      int j = paramString4.length();
      paramString1.setSpan(paramQQAppInterface, i, paramContext.length() + j, 33);
    }
    return paramString1;
  }
  
  private static bgcz a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, int paramInt, Paint paramPaint, boolean paramBoolean2)
  {
    if ((paramQQAppInterface == null) || (paramContext == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (paramInt <= 0)) {}
    for (;;)
    {
      return null;
      if (paramBoolean2) {
        if ((!paramBoolean1) && (!paramString2.equalsIgnoreCase("0")))
        {
          paramString1 = ContactUtils.getTroopMemberNameWithoutRemark(paramQQAppInterface, paramString1, paramString2);
          paramQQAppInterface = paramString1;
          if (TextUtils.isEmpty(paramString1))
          {
            paramQQAppInterface = paramString1;
            if (!TextUtils.isEmpty(paramString3)) {
              paramQQAppInterface = paramString3;
            }
          }
        }
      }
      while (!TextUtils.isEmpty(paramQQAppInterface))
      {
        if (QLog.isColorLevel()) {
          QLog.d("_At_Me_DISC", 2, " memUin:" + paramString2 + " troopMemName:" + bhbx.a(paramQQAppInterface) + " isTroop:" + paramBoolean2);
        }
        return new bgcz(paramContext, paramString2, paramQQAppInterface, paramInt, paramPaint);
        paramQQAppInterface = paramString3;
        continue;
        if (!paramString2.equalsIgnoreCase("0"))
        {
          paramString1 = ContactUtils.getBuddyNickName(paramQQAppInterface, paramString2, true);
          paramQQAppInterface = paramString1;
          if (a(paramString2, paramString1, paramString3)) {
            paramQQAppInterface = paramString3;
          }
        }
        else
        {
          paramQQAppInterface = paramString3;
        }
      }
    }
  }
  
  public static String a(Spannable paramSpannable, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList)
  {
    return a(paramSpannable, paramArrayList).toString();
  }
  
  private static String a(CharSequence paramCharSequence)
  {
    paramCharSequence = new StringBuffer(paramCharSequence);
    int i = 0;
    if (i < paramCharSequence.length())
    {
      int k = paramCharSequence.codePointAt(i);
      int j;
      if ((k == 20) && (i < paramCharSequence.length() - 1))
      {
        paramCharSequence.delete(i, i + 2);
        j = i - 1;
      }
      do
      {
        i = j + 1;
        break;
        j = i;
      } while (EmotcationConstants.EMOJI_MAP.get(k, -1) < 0);
      if ((k > 65535) && (paramCharSequence.length() >= i + 2)) {
        paramCharSequence.delete(i, i + 2);
      }
      for (;;)
      {
        j = i - 1;
        break;
        paramCharSequence.delete(i, i + 1);
      }
    }
    return paramCharSequence.toString();
  }
  
  public static String a(ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList)
  {
    try
    {
      JSONArray localJSONArray = new JSONArray();
      paramArrayList = paramArrayList.iterator();
      int i = 0;
      while (paramArrayList.hasNext())
      {
        localJSONArray.put(i, ((MessageForText.AtTroopMemberInfo)paramArrayList.next()).toJsonObject());
        i += 1;
      }
      paramArrayList = localJSONArray.toString();
      return paramArrayList;
    }
    catch (Exception paramArrayList)
    {
      QLog.e("AtTroopMemberSpan", 1, "convertAtinfo2Json fail: ", paramArrayList);
    }
    return null;
  }
  
  public static StringBuilder a(QQAppInterface paramQQAppInterface, StringBuilder paramStringBuilder, String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramStringBuilder.toString())) || (TextUtils.isEmpty(paramString2)) || (paramBoolean))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AtTroopMemberSpan_At_Me_DISC", 2, "Recv replaceAtMsgByMarkName return discUin:" + paramString2);
      }
      paramString1 = paramStringBuilder;
    }
    do
    {
      return paramString1;
      try
      {
        localJSONArray = new JSONArray(paramString1);
        m = localJSONArray.length();
        i = 0;
        j = 0;
      }
      catch (JSONException paramQQAppInterface)
      {
        try
        {
          JSONArray localJSONArray;
          int m;
          int i;
          JSONObject localJSONObject = localJSONArray.getJSONObject(i);
          paramString1 = paramStringBuilder;
          localStringBuilder = paramStringBuilder;
          int i1 = (byte)localJSONObject.optInt("flag", 1);
          paramString1 = paramStringBuilder;
          localStringBuilder = paramStringBuilder;
          String str = localJSONObject.optString("uin");
          paramString1 = paramStringBuilder;
          localStringBuilder = paramStringBuilder;
          int i2 = localJSONObject.optInt("startPos", 0);
          paramString1 = paramStringBuilder;
          localStringBuilder = paramStringBuilder;
          int n = localJSONObject.optInt("textLen", 0);
          int k = j;
          paramString1 = paramStringBuilder;
          if (i1 == 0)
          {
            paramString1 = paramStringBuilder;
            localStringBuilder = paramStringBuilder;
            str = "@" + ContactUtils.getDiscussionMemberShowName(paramQQAppInterface, paramString2, str);
            paramString1 = paramStringBuilder;
            localStringBuilder = paramStringBuilder;
            paramStringBuilder = paramStringBuilder.replace(i2 + j, i2 + n + j, str);
            paramString1 = paramStringBuilder;
            localStringBuilder = paramStringBuilder;
            k = str.length();
            k = j + (k - n);
            paramString1 = paramStringBuilder;
          }
          i += 1;
          int j = k;
          paramStringBuilder = paramString1;
        }
        catch (Exception paramQQAppInterface)
        {
          StringBuilder localStringBuilder;
          break label297;
        }
        catch (JSONException paramQQAppInterface)
        {
          break label280;
        }
        paramQQAppInterface = paramQQAppInterface;
        localStringBuilder = paramStringBuilder;
        QLog.e("_At_Me_DISC", 1, "replaceAtMsgByMarkName_1 ", paramQQAppInterface);
        return localStringBuilder;
      }
      catch (Exception paramQQAppInterface)
      {
        paramString1 = paramStringBuilder;
        QLog.e("_At_Me_DISC", 1, "replaceAtMsgByMarkName_2", paramQQAppInterface);
        return paramString1;
      }
      paramString1 = paramStringBuilder;
    } while (i >= m);
    paramString1 = paramStringBuilder;
    localStringBuilder = paramStringBuilder;
  }
  
  private List<bimv> a(Paint paramPaint)
  {
    int i = (int)Math.ceil(paramPaint.measureText(" "));
    List localList = bhmb.a(this.jdField_b_of_type_Int - i * 2, this.jdField_b_of_type_JavaLangString, paramPaint, this.jdField_a_of_type_Bimw, 16);
    localList.add(new bimv(1, 0, 0, "  ", null));
    this.jdField_a_of_type_Int = bhmb.a(localList, paramPaint, new Rect());
    return localList;
  }
  
  public static void a(int paramInt, String paramString, ChatMessage paramChatMessage)
  {
    if (paramInt == 1) {
      paramChatMessage.saveExtInfoToExtStr("troop_at_info_list", paramString);
    }
    while (paramInt != 3000) {
      return;
    }
    paramChatMessage.saveExtInfoToExtStr("disc_at_info_list", paramString);
  }
  
  public static void a(int paramInt, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList, ChatMessage paramChatMessage)
  {
    if (((paramInt == 3000) || (paramInt == 1)) && (paramArrayList.size() > 0))
    {
      try
      {
        JSONArray localJSONArray = new JSONArray();
        paramArrayList = paramArrayList.iterator();
        int i = 0;
        while (paramArrayList.hasNext())
        {
          localJSONArray.put(i, ((MessageForText.AtTroopMemberInfo)paramArrayList.next()).toJsonObject());
          i += 1;
        }
        if (paramInt == 1)
        {
          paramChatMessage.saveExtInfoToExtStr("troop_at_info_list", localJSONArray.toString());
          return;
        }
        if (paramInt != 3000) {
          return;
        }
        paramChatMessage.saveExtInfoToExtStr("disc_at_info_list", localJSONArray.toString());
        return;
      }
      catch (JSONException paramArrayList)
      {
        paramArrayList.printStackTrace();
        return;
      }
    }
    else if (((paramInt == 3000) || (paramInt == 1)) && (paramArrayList.size() == 0))
    {
      if (paramInt == 1)
      {
        paramChatMessage.removeExtInfoToExtStr("troop_at_info_list");
        return;
      }
      if (paramInt == 3000) {
        paramChatMessage.removeExtInfoToExtStr("disc_at_info_list");
      }
    }
  }
  
  private void a(Paint paramPaint)
  {
    float f1 = 0.0F;
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
      return;
    }
    Object localObject2 = a(paramPaint);
    Object localObject1 = paramPaint.getFontMetrics();
    float f2 = -((Paint.FontMetrics)localObject1).top;
    int i = (int)Math.ceil(((Paint.FontMetrics)localObject1).bottom - ((Paint.FontMetrics)localObject1).top);
    Object localObject3 = new RectF(0.0F, ((Paint.FontMetrics)localObject1).ascent - ((Paint.FontMetrics)localObject1).top, this.jdField_a_of_type_Int - 2, ((Paint.FontMetrics)localObject1).descent + f2);
    localObject1 = Bitmap.createBitmap(this.jdField_a_of_type_Int, i, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas((Bitmap)localObject1);
    int j = paramPaint.getColor();
    paramPaint.setColor(-4331268);
    localCanvas.drawRect((RectF)localObject3, paramPaint);
    paramPaint.setColor(j);
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (bimv)((Iterator)localObject2).next();
      switch (((bimv)localObject3).c)
      {
      default: 
        break;
      case 1: 
        localCanvas.drawText(((bimv)localObject3).jdField_a_of_type_JavaLangString, f1, f2, paramPaint);
        f1 += paramPaint.measureText(((bimv)localObject3).jdField_a_of_type_JavaLangString);
        break;
      case 2: 
        localObject3 = (QQText.EmoticonSpan)((bimv)localObject3).jdField_a_of_type_AndroidTextStyleCharacterStyle;
        j = ((QQText.EmoticonSpan)localObject3).getDrawable().getBounds().height();
        ((QQText.EmoticonSpan)localObject3).draw(localCanvas, "", 0, 0, f1, (i - j) / 2, (i + j) / 2, (j + i) / 2, paramPaint);
        f1 += ((QQText.EmoticonSpan)localObject3).getDrawable().getBounds().width();
      }
    }
    localCanvas.save();
    localCanvas.restore();
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), (Bitmap)localObject1);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.jdField_a_of_type_Int, i);
  }
  
  private static boolean a(String paramString1, String paramString2, String paramString3)
  {
    boolean bool2 = false;
    boolean bool1;
    if (!TextUtils.isEmpty(paramString2))
    {
      bool1 = bool2;
      if (!paramString2.equals(paramString1)) {}
    }
    else
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramString3)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void draw(@NonNull Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, @NonNull Paint paramPaint)
  {
    if ((paramInt2 - paramInt1 == 1) && (this.c.length() != 1) && (paramInt1 != 0)) {
      return;
    }
    super.draw(paramCanvas, paramCharSequence, paramInt1, paramInt2, paramFloat, paramInt3, paramInt4, paramInt5, paramPaint);
  }
  
  public Drawable getDrawable()
  {
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  public int getSize(@NonNull Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, @Nullable Paint.FontMetricsInt paramFontMetricsInt)
  {
    if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) || ((paramInt2 - paramInt1 == 1) && (this.c.length() != 1) && (paramInt1 != 0))) {
      return 0;
    }
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getBounds().right;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgcz
 * JD-Core Version:    0.7.0.1
 */