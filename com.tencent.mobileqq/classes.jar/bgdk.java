import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.DraftTextInfo;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emoticonview.SmallEmoticonInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQText.EmoticonSpan;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.ColorNickManager.2;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.widget.ColorClearableEditText;
import com.tencent.mobileqq.widget.ColorNickTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x8fc.Oidb_0x8fc.CommCardNameBuf;
import tencent.im.oidb.cmd0x8fc.Oidb_0x8fc.RichCardNameElem;

public class bgdk
  implements Manager
{
  private static bgdo jdField_a_of_type_Bgdo = new bgdo(null);
  public static final String a;
  public static AtomicBoolean a;
  public Handler a;
  private arep jdField_a_of_type_Arep = new bgdm(this);
  public bgdr a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private VasQuickUpdateManager.CallBacker jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker = new bgdn(this);
  private Vector<Integer> jdField_a_of_type_JavaUtilVector = new Vector();
  public ConcurrentHashMap<Integer, bgdq> a;
  
  static
  {
    jdField_a_of_type_JavaLangString = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + ".CorlorNick/");
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  public bgdk(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Bgdr = new bgdr(this);
  }
  
  public static int a(List<bhcd> paramList, Paint paramPaint, Rect paramRect)
  {
    Rect localRect = new Rect();
    paramList = paramList.iterator();
    int i = 0;
    if (paramList.hasNext())
    {
      bhcd localbhcd = (bhcd)paramList.next();
      switch (localbhcd.c)
      {
      }
      for (;;)
      {
        break;
        int j = (int)Math.ceil(paramPaint.measureText(localbhcd.jdField_a_of_type_JavaLangString));
        paramPaint.getTextBounds(localbhcd.jdField_a_of_type_JavaLangString, 0, localbhcd.jdField_a_of_type_JavaLangString.length(), localRect);
        paramRect.bottom = Math.max(paramRect.bottom, localRect.height());
        i += j;
        continue;
        i += ((QQText.EmoticonSpan)localbhcd.jdField_a_of_type_AndroidTextStyleCharacterStyle).getDrawable().getBounds().width();
        paramRect.bottom = Math.max(paramRect.bottom, ((QQText.EmoticonSpan)localbhcd.jdField_a_of_type_AndroidTextStyleCharacterStyle).getDrawable().getBounds().height());
      }
    }
    paramRect.left = 0;
    paramRect.right = i;
    paramRect.top = 0;
    return i;
  }
  
  public static bgdk a(QQAppInterface paramQQAppInterface)
  {
    return ((bgga)paramQQAppInterface.getManager(235)).a;
  }
  
  private bgdq a(File paramFile, int paramInt)
  {
    int i = 0;
    paramFile = FileUtils.readFileToStringEx(paramFile, -1);
    try
    {
      paramFile = new JSONObject(paramFile);
      bgdq localbgdq = new bgdq();
      paramFile = paramFile.optJSONArray("baseInfo");
      if ((paramFile != null) && (paramFile.length() > 0))
      {
        Object localObject = paramFile.getJSONObject(0);
        localbgdq.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("type");
        if (localbgdq.jdField_a_of_type_Int == 5)
        {
          localObject = jdField_a_of_type_JavaLangString + paramInt + File.separator + "shaderImg.png";
          paramFile = localbgdq;
          if (!new File((String)localObject).exists()) {
            return paramFile;
          }
          localbgdq.jdField_a_of_type_AndroidGraphicsBitmap = bfvo.a((String)localObject, null);
          return localbgdq;
        }
        localbgdq.b = ((JSONObject)localObject).optInt("orientation");
        paramFile = ((JSONObject)localObject).optJSONArray("colors");
        if ((paramFile != null) && (paramFile.length() > 0))
        {
          localbgdq.jdField_a_of_type_ArrayOfInt = new int[paramFile.length()];
          paramInt = 0;
          while (paramInt < paramFile.length())
          {
            String str = paramFile.getString(paramInt);
            localbgdq.jdField_a_of_type_ArrayOfInt[paramInt] = Color.parseColor(str);
            paramInt += 1;
          }
        }
        if ((localbgdq.jdField_a_of_type_Int != 1) && (localbgdq.jdField_a_of_type_Int != 2))
        {
          paramFile = localbgdq;
          if (localbgdq.jdField_a_of_type_Int != 3) {
            return paramFile;
          }
        }
        localObject = ((JSONObject)localObject).optJSONArray("positions");
        paramFile = localbgdq;
        if (localObject == null) {
          return paramFile;
        }
        paramFile = localbgdq;
        if (((JSONArray)localObject).length() <= 0) {
          return paramFile;
        }
        localbgdq.jdField_a_of_type_ArrayOfFloat = new float[((JSONArray)localObject).length()];
        paramInt = i;
        for (;;)
        {
          paramFile = localbgdq;
          if (paramInt >= ((JSONArray)localObject).length()) {
            break;
          }
          paramFile = ((JSONArray)localObject).getString(paramInt);
          if (TextUtils.isDigitsOnly(paramFile))
          {
            i = Integer.parseInt(paramFile);
            localbgdq.jdField_a_of_type_ArrayOfFloat[paramInt] = (i / 100.0F);
          }
          paramInt += 1;
        }
      }
      return paramFile;
    }
    catch (Exception paramFile)
    {
      QLog.e("ColorNick", 1, "loadGradientConfig error: ", paramFile);
      paramFile = null;
    }
  }
  
  public static CharSequence a(MessageRecord paramMessageRecord, MsgSummary paramMsgSummary)
  {
    SpannableString localSpannableString;
    Object localObject;
    if ((!TextUtils.isEmpty(paramMsgSummary.strContent)) || (!TextUtils.isEmpty(paramMsgSummary.suffix)))
    {
      localSpannableString = null;
      if (TextUtils.isEmpty(paramMsgSummary.strContent)) {
        break label218;
      }
      String str = paramMsgSummary.strContent.toString();
      localObject = str;
      if (!TextUtils.isEmpty(paramMsgSummary.strPrefix))
      {
        localObject = str;
        if (TextUtils.indexOf(paramMsgSummary.strContent, paramMsgSummary.strPrefix) == 0)
        {
          if (paramMsgSummary.strContent.length() <= paramMsgSummary.strPrefix.length() + 2) {
            break label211;
          }
          localObject = (String)str.subSequence(paramMsgSummary.strPrefix.length() + 2, paramMsgSummary.strContent.length());
        }
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramMsgSummary.strPrefix)) {
        localSpannableString = new bczs(paramMsgSummary.strPrefix, 16).a();
      }
      paramMessageRecord = a((String)localObject, paramMessageRecord, 16, 5);
      localObject = new SpannableStringBuilder();
      if (localSpannableString != null) {
        ((SpannableStringBuilder)localObject).append(localSpannableString).append(": ");
      }
      ((SpannableStringBuilder)localObject).append(paramMessageRecord);
      paramMsgSummary.strContent = new QQText((CharSequence)localObject, 5, 16);
      return paramMsgSummary.strContent;
      label211:
      localObject = "";
      continue;
      label218:
      localObject = paramMsgSummary.suffix.toString();
    }
  }
  
  public static CharSequence a(String paramString, MessageRecord paramMessageRecord, int paramInt1, int paramInt2)
  {
    String str;
    if (paramMessageRecord != null)
    {
      str = paramMessageRecord.getExtInfoFromExtStr(bbkv.i);
      if (!(paramMessageRecord instanceof MessageForReplyText)) {
        break label71;
      }
      MessageForReplyText localMessageForReplyText = (MessageForReplyText)paramMessageRecord;
      if (localMessageForReplyText.mSourceMsgInfo == null) {
        break label71;
      }
      str = bevt.a(localMessageForReplyText.mSourceMsgInfo.mSourceMsgSenderUin, str);
    }
    label71:
    for (;;)
    {
      return a(paramString, str, paramInt1, paramMessageRecord, paramInt2);
      return new QQText(paramString, paramInt2, paramInt1, paramMessageRecord);
    }
  }
  
  public static CharSequence a(String paramString1, String paramString2, int paramInt1, MessageRecord paramMessageRecord, int paramInt2)
  {
    int k = 0;
    if (!TextUtils.isEmpty(paramString2))
    {
      paramString2 = MessageForText.getTroopMemberInfoFromExtrJson(paramString2);
      if ((paramString2 != null) && (paramString2.size() > 0))
      {
        Object localObject = new ArrayList();
        int i = 0;
        MessageForText.AtTroopMemberInfo localAtTroopMemberInfo;
        int j;
        while (i < paramString2.size())
        {
          localAtTroopMemberInfo = (MessageForText.AtTroopMemberInfo)paramString2.get(i);
          if ((localAtTroopMemberInfo.startPos < 0) || (localAtTroopMemberInfo.startPos + localAtTroopMemberInfo.textLen > paramString1.length()))
          {
            i += 1;
          }
          else
          {
            bgdp localbgdp = new bgdp(null);
            localbgdp.jdField_a_of_type_Int = localAtTroopMemberInfo.startPos;
            if (localAtTroopMemberInfo.startPos + localAtTroopMemberInfo.textLen > paramString1.length()) {}
            for (j = paramString1.length();; j = localAtTroopMemberInfo.textLen + j)
            {
              localbgdp.b = j;
              localbgdp.jdField_a_of_type_AndroidTextSpannableString = new bczs(paramString1.subSequence(localbgdp.jdField_a_of_type_Int, localbgdp.b), paramInt1).a();
              ((ArrayList)localObject).add(localbgdp);
              break;
              j = localAtTroopMemberInfo.startPos;
            }
          }
        }
        if (((ArrayList)localObject).size() > 0)
        {
          paramString2 = (bgdp[])((ArrayList)localObject).toArray(new bgdp[((ArrayList)localObject).size()]);
          Arrays.sort(paramString2, jdField_a_of_type_Bgdo);
          localObject = new SpannableStringBuilder();
          int m = paramString2.length;
          j = 0;
          i = k;
          if (i < m)
          {
            localAtTroopMemberInfo = paramString2[i];
            if (localAtTroopMemberInfo.jdField_a_of_type_Int >= j) {
              ((SpannableStringBuilder)localObject).append(new QQText(paramString1.subSequence(j, localAtTroopMemberInfo.b), paramInt2, paramInt1, paramMessageRecord));
            }
            for (;;)
            {
              j = localAtTroopMemberInfo.b;
              i += 1;
              break;
              ((SpannableStringBuilder)localObject).append(localAtTroopMemberInfo.jdField_a_of_type_AndroidTextSpannableString);
            }
          }
          if (j < paramString1.length()) {
            ((SpannableStringBuilder)localObject).append(new QQText(paramString1.subSequence(j, paramString1.length()), paramInt2, paramInt1, paramMessageRecord));
          }
          return localObject;
        }
      }
    }
    return new QQText(paramString1, paramInt2, paramInt1, paramMessageRecord);
  }
  
  public static String a(bgdd parambgdd)
  {
    int j = 0;
    char[] arrayOfChar = new char[7];
    arrayOfChar[0] = '<';
    arrayOfChar[1] = '%';
    arrayOfChar[2] = ((char)(parambgdd.b >>> 24 & 0xFF));
    arrayOfChar[3] = ((char)(parambgdd.b >>> 16 & 0xFF));
    arrayOfChar[4] = ((char)(parambgdd.b >>> 8 & 0xFF));
    arrayOfChar[5] = ((char)(parambgdd.b & 0xFF));
    arrayOfChar[6] = '>';
    int i = j;
    switch (parambgdd.jdField_a_of_type_Int)
    {
    default: 
      i = j;
    }
    while (i < arrayOfChar.length)
    {
      if (arrayOfChar[i] == 0) {
        arrayOfChar[i] = 'Ā';
      }
      i += 1;
      continue;
      if (parambgdd.b == 0) {
        return "";
      }
      arrayOfChar[1] = '&';
      i = j;
    }
    return new String(arrayOfChar);
  }
  
  public static String a(ByteStringMicro paramByteStringMicro)
  {
    String str2 = a(paramByteStringMicro.toByteArray());
    String str1 = str2;
    if (str2 == null) {
      str1 = paramByteStringMicro.toStringUtf8();
    }
    return str1;
  }
  
  public static String a(String paramString)
  {
    return jdField_a_of_type_JavaLangString + paramString + File.separator + "xydata.json";
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    try
    {
      Object localObject = new Oidb_0x8fc.CommCardNameBuf();
      ((Oidb_0x8fc.CommCardNameBuf)localObject).mergeFrom(paramArrayOfByte);
      if (((Oidb_0x8fc.CommCardNameBuf)localObject).rpt_rich_card_name.has())
      {
        paramArrayOfByte = new StringBuilder();
        localObject = ((Oidb_0x8fc.CommCardNameBuf)localObject).rpt_rich_card_name.get().iterator();
        while (((Iterator)localObject).hasNext())
        {
          Oidb_0x8fc.RichCardNameElem localRichCardNameElem = (Oidb_0x8fc.RichCardNameElem)((Iterator)localObject).next();
          if (localRichCardNameElem.bytes_ctrl.has()) {
            paramArrayOfByte.append("<").append(localRichCardNameElem.bytes_ctrl.get().toStringUtf8()).append(">");
          } else if (localRichCardNameElem.bytes_text.has()) {
            paramArrayOfByte.append(localRichCardNameElem.bytes_text.get().toStringUtf8());
          }
        }
        paramArrayOfByte = paramArrayOfByte.toString();
        return paramArrayOfByte;
      }
      return null;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte) {}
    return null;
  }
  
  public static List<bhcd> a(int paramInt1, String paramString, Paint paramPaint, bhce parambhce, int paramInt2)
  {
    Object localObject = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    ColorClearableEditText.a((List)localObject, parambhce, new bczs(paramString, paramInt2).a());
    int i = (int)Math.ceil(paramPaint.measureText("..."));
    paramString = ((ArrayList)localObject).iterator();
    paramInt2 = 0;
    if (paramString.hasNext())
    {
      parambhce = (bhcd)paramString.next();
      switch (parambhce.c)
      {
      }
      for (;;)
      {
        break;
        localObject = bcro.a(paramInt1 - paramInt2, parambhce.jdField_a_of_type_JavaLangString, paramPaint);
        int j;
        if (((String)localObject).equals(parambhce.jdField_a_of_type_JavaLangString))
        {
          j = (int)Math.ceil(paramPaint.measureText(parambhce.jdField_a_of_type_JavaLangString));
          localArrayList.add(parambhce);
          paramInt2 += j;
        }
        else
        {
          parambhce.jdField_a_of_type_JavaLangString = ((String)localObject);
          localArrayList.add(parambhce);
          return localArrayList;
          j = ((QQText.EmoticonSpan)parambhce.jdField_a_of_type_AndroidTextStyleCharacterStyle).getDrawable().getBounds().width();
          if (j > paramInt1 - paramInt2 - i)
          {
            localArrayList.add(new bhcd(1, parambhce.jdField_a_of_type_Int, parambhce.b, "...", null));
            return localArrayList;
          }
          localArrayList.add(parambhce);
          paramInt2 += j;
          continue;
          localArrayList.add(parambhce);
        }
      }
    }
    return localArrayList;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, TextView paramTextView, Spannable paramSpannable)
  {
    if (bbyp.b()) {}
    label228:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              paramSpannable = (bged[])paramSpannable.getSpans(0, paramSpannable.length(), bged.class);
              if ((paramSpannable == null) || (paramSpannable.length <= 0)) {
                break label228;
              }
              paramSpannable = paramSpannable[0];
              if (paramSpannable.jdField_a_of_type_Int != 2) {
                break;
              }
              paramTextView.setTextColor(paramSpannable.b);
              if ((paramTextView instanceof ColorClearableEditText))
              {
                ((ColorClearableEditText)paramTextView).setSpecialColor(0, null, null, 0, null);
                return;
              }
            } while (!(paramTextView instanceof ColorNickTextView));
            ((ColorNickTextView)paramTextView).setSpecialColor(0, null, null, 0, null);
            return;
          } while (paramSpannable.jdField_a_of_type_Int != 3);
          paramQQAppInterface = a(paramQQAppInterface).a(paramSpannable.b);
          if (paramQQAppInterface == null) {
            break;
          }
          if ((paramTextView instanceof ColorClearableEditText))
          {
            paramTextView.setTextColor(-16777216);
            ((ColorClearableEditText)paramTextView).setSpecialColor(paramQQAppInterface.jdField_a_of_type_Int, paramQQAppInterface.jdField_a_of_type_ArrayOfInt, paramQQAppInterface.jdField_a_of_type_ArrayOfFloat, paramQQAppInterface.b, paramQQAppInterface.jdField_a_of_type_AndroidGraphicsBitmap);
            return;
          }
        } while (!(paramTextView instanceof ColorNickTextView));
        paramTextView.setTextColor(-16777216);
        ((ColorNickTextView)paramTextView).setSpecialColor(paramQQAppInterface.jdField_a_of_type_Int, paramQQAppInterface.jdField_a_of_type_ArrayOfInt, paramQQAppInterface.jdField_a_of_type_ArrayOfFloat, paramQQAppInterface.b, paramQQAppInterface.jdField_a_of_type_AndroidGraphicsBitmap);
        ((ColorNickTextView)paramTextView).a = false;
        return;
      } while (!(paramTextView instanceof ColorNickTextView));
      ((ColorNickTextView)paramTextView).a = true;
      return;
      if ((paramTextView instanceof ColorClearableEditText))
      {
        ((ColorClearableEditText)paramTextView).setSpecialColor(0, null, null, 0, null);
        return;
      }
    } while (!(paramTextView instanceof ColorNickTextView));
    ((ColorNickTextView)paramTextView).setSpecialColor(0, null, null, 0, null);
  }
  
  public static void a(DraftTextInfo paramDraftTextInfo, XEditTextEx paramXEditTextEx, String paramString1, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, String paramString2)
  {
    if ((paramDraftTextInfo != null) && (!TextUtils.isEmpty(paramDraftTextInfo.mAtInfoStr)) && (!TextUtils.isEmpty(paramString1)))
    {
      paramDraftTextInfo = MessageForText.getTroopMemberInfoFromExtrJson(paramDraftTextInfo.mAtInfoStr);
      if (paramDraftTextInfo != null)
      {
        paramDraftTextInfo = paramDraftTextInfo.iterator();
        while (paramDraftTextInfo.hasNext())
        {
          MessageForText.AtTroopMemberInfo localAtTroopMemberInfo = (MessageForText.AtTroopMemberInfo)paramDraftTextInfo.next();
          if ((localAtTroopMemberInfo.startPos <= paramXEditTextEx.getEditableText().length()) && (localAtTroopMemberInfo.startPos + localAtTroopMemberInfo.textLen + 1 <= paramXEditTextEx.getEditableText().length()))
          {
            SpannableString localSpannableString = bevq.a(paramQQAppInterface, paramBaseActivity, paramString2, Long.toString(localAtTroopMemberInfo.uin), paramString1.substring(localAtTroopMemberInfo.startPos + 1, localAtTroopMemberInfo.startPos + localAtTroopMemberInfo.textLen), false, paramXEditTextEx, true);
            if (localSpannableString != null) {
              paramXEditTextEx.getEditableText().replace(localAtTroopMemberInfo.startPos, localAtTroopMemberInfo.startPos + localAtTroopMemberInfo.textLen + 1, localSpannableString);
            }
          }
        }
      }
    }
  }
  
  public static void a(SmallEmoticonInfo paramSmallEmoticonInfo, QQAppInterface paramQQAppInterface, EditText paramEditText)
  {
    if (paramSmallEmoticonInfo.emoticon == null)
    {
      bggr.a("emotionType", "emotionActionSend", "1", "", "", "", "", "", "", "");
      QLog.e("ColorNick", 1, "fail to send small_emotion.");
      return;
    }
    try
    {
      int i = Integer.parseInt(paramSmallEmoticonInfo.emoticon.eId);
      int j = Integer.parseInt(paramSmallEmoticonInfo.emoticon.epId);
      ((avsq)paramQQAppInterface.getManager(14)).a(String.valueOf(j), new bgdl(j, i, paramEditText));
      return;
    }
    catch (NumberFormatException paramSmallEmoticonInfo)
    {
      bggr.a("emotionType", "emotionActionSend", "4", "", "", "", "", "", "", "");
      QLog.e("ColorNick", 1, "fail to send small_emotion. id is not Int.");
    }
  }
  
  private void a(List<bhcd> paramList, Paint paramPaint, bgdq parambgdq, Canvas paramCanvas, float paramFloat1, float paramFloat2)
  {
    Paint localPaint = new Paint(paramPaint);
    int i = 0;
    Rect localRect = new Rect();
    int j = 0;
    bhcd localbhcd;
    while (j < paramList.size())
    {
      localbhcd = (bhcd)paramList.get(j);
      switch (localbhcd.c)
      {
      default: 
        j += 1;
        break;
      case 1: 
        if (i != 0) {
          break label380;
        }
        paramPaint.getTextBounds(localbhcd.jdField_a_of_type_JavaLangString, 0, localbhcd.jdField_a_of_type_JavaLangString.length(), localRect);
        i = localRect.height();
      }
    }
    label162:
    label186:
    label201:
    label342:
    label380:
    for (;;)
    {
      int k = 0;
      if (k < localbhcd.jdField_a_of_type_JavaLangString.length())
      {
        float f5 = paramPaint.measureText(localbhcd.jdField_a_of_type_JavaLangString, k, k + 1);
        float f1;
        float f2;
        float f3;
        if (parambgdq.b == 1)
        {
          f1 = paramFloat1;
          if (parambgdq.b != 1) {
            break label317;
          }
          f2 = i * 0.5F + paramFloat2 - i;
          if (parambgdq.b != 1) {
            break label328;
          }
          f3 = paramFloat1 + f5;
          if (parambgdq.b != 1) {
            break label342;
          }
        }
        for (float f4 = i * 0.5F + paramFloat2 - i;; f4 = i)
        {
          localPaint.setShader(new LinearGradient(f1, f2, f3, f4, parambgdq.jdField_a_of_type_ArrayOfInt, parambgdq.jdField_a_of_type_ArrayOfFloat, Shader.TileMode.CLAMP));
          localPaint.setStyle(Paint.Style.FILL);
          paramCanvas.drawRect(paramFloat1, paramFloat2 - i, paramFloat1 + f5, paramFloat2, localPaint);
          paramFloat1 += f5;
          k += 1;
          break;
          f1 = paramFloat1 + 0.5F * f5;
          break label162;
          f2 = paramFloat2 - i;
          break label186;
          f3 = paramFloat1 + 0.5F * f5;
          break label201;
        }
      }
      break;
      paramFloat1 += ((QQText.EmoticonSpan)localbhcd.jdField_a_of_type_AndroidTextStyleCharacterStyle).getDrawable().getBounds().width();
      break;
      return;
    }
  }
  
  public static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < paramString.length())
    {
      if (paramString.charAt(i) == '<')
      {
        int j = paramString.indexOf('>', i);
        if (j > 0) {
          i = j;
        }
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append(paramString.charAt(i));
      }
    }
    return localStringBuilder.toString();
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilVector.contains(Integer.valueOf(paramInt)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ColorNick", 2, "downloadGradientConfig id = " + paramInt + " is downloading");
      }
      return;
    }
    this.jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(paramInt));
    VasQuickUpdateManager localVasQuickUpdateManager = (VasQuickUpdateManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(184);
    localVasQuickUpdateManager.addCallBacker(this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
    localVasQuickUpdateManager.downloadItem(27L, "groupnickitem." + paramInt, "ColorNickManager");
  }
  
  public Shader a(int paramInt1, List<bhcd> paramList, float paramFloat1, float paramFloat2, Rect paramRect, Paint paramPaint, int paramInt2, int paramInt3)
  {
    bgdq localbgdq = a(paramInt1);
    if (localbgdq != null) {
      switch (localbgdq.jdField_a_of_type_Int)
      {
      }
    }
    label90:
    label108:
    do
    {
      return null;
      float f1;
      float f2;
      if (localbgdq.b == 1)
      {
        f1 = paramFloat1;
        if (localbgdq.b != 1) {
          break label177;
        }
        f2 = paramFloat2 + paramRect.height() * 0.5F;
        if (localbgdq.b != 1) {
          break label184;
        }
        paramFloat1 += paramRect.width();
        if (localbgdq.b != 1) {
          break label200;
        }
      }
      for (paramFloat2 += paramRect.height() * 0.5F;; paramFloat2 += paramRect.height())
      {
        return new LinearGradient(f1, f2, paramFloat1, paramFloat2, localbgdq.jdField_a_of_type_ArrayOfInt, localbgdq.jdField_a_of_type_ArrayOfFloat, Shader.TileMode.CLAMP);
        f1 = paramFloat1 + paramRect.width() * 0.5F;
        break;
        f2 = paramFloat2;
        break label90;
        paramFloat1 += paramRect.width() * 0.5F;
        break label108;
      }
      localObject1 = Bitmap.createBitmap(paramInt2, paramInt3, Bitmap.Config.ARGB_8888);
      a(paramList, paramPaint, localbgdq, new Canvas((Bitmap)localObject1), paramFloat1, paramFloat2 + paramRect.height());
      return new BitmapShader((Bitmap)localObject1, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
      return new RadialGradient(paramRect.width() / 2 + paramFloat1, paramRect.height() / 2 + paramFloat2, paramRect.width() / 2, localbgdq.jdField_a_of_type_ArrayOfInt, localbgdq.jdField_a_of_type_ArrayOfFloat, Shader.TileMode.CLAMP);
      paramRect = Bitmap.createBitmap(paramInt2, paramInt3, Bitmap.Config.ARGB_8888);
      localObject1 = new Canvas(paramRect);
      localObject2 = new Paint(paramPaint);
      paramInt1 = 0;
      paramInt2 = 0;
      if (paramInt2 < paramList.size())
      {
        localObject3 = (bhcd)paramList.get(paramInt2);
        switch (((bhcd)localObject3).c)
        {
        }
        for (;;)
        {
          paramInt2 += 1;
          break;
          int i = 0;
          while (i < ((bhcd)localObject3).jdField_a_of_type_JavaLangString.length())
          {
            paramFloat2 = paramPaint.measureText(((bhcd)localObject3).jdField_a_of_type_JavaLangString, i, i + 1);
            ((Paint)localObject2).setColor(localbgdq.jdField_a_of_type_ArrayOfInt[(paramInt1 % localbgdq.jdField_a_of_type_ArrayOfInt.length)]);
            ((Paint)localObject2).setStyle(Paint.Style.FILL);
            ((Canvas)localObject1).drawRect(paramFloat1, 0.0F, paramFloat1 + paramFloat2, paramInt3, (Paint)localObject2);
            i += 1;
            paramInt1 += 1;
            paramFloat1 += paramFloat2;
          }
          continue;
          paramFloat1 += ((QQText.EmoticonSpan)((bhcd)localObject3).jdField_a_of_type_AndroidTextStyleCharacterStyle).getDrawable().getBounds().width();
        }
      }
      return new BitmapShader(paramRect, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
    } while (localbgdq.jdField_a_of_type_AndroidGraphicsBitmap == null);
    label177:
    label184:
    label200:
    paramList = Bitmap.createBitmap(paramInt2, paramInt3, Bitmap.Config.ARGB_8888);
    Object localObject1 = new Canvas(paramList);
    paramInt1 = localbgdq.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
    Object localObject2 = new Rect();
    Object localObject3 = new Rect(0, 0, paramInt1, localbgdq.jdField_a_of_type_AndroidGraphicsBitmap.getHeight());
    for (paramFloat1 = 0.0F; paramFloat1 < paramRect.width(); paramFloat1 += paramInt1)
    {
      ((Rect)localObject2).set((int)paramFloat1, 0, (int)(paramInt1 + paramFloat1), paramInt3);
      ((Canvas)localObject1).drawBitmap(localbgdq.jdField_a_of_type_AndroidGraphicsBitmap, (Rect)localObject3, (Rect)localObject2, paramPaint);
    }
    return new BitmapShader(paramList, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
  }
  
  public bgdq a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(paramInt))) {
      return (bgdq)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    }
    a(paramInt);
    return null;
  }
  
  void a(int paramInt)
  {
    ThreadManagerV2.excute(new ColorNickManager.2(this, paramInt), 64, null, true);
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgdk
 * JD-Core Version:    0.7.0.1
 */