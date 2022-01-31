import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aqag
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = 9223372036854775807L;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private volatile boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 3;
  private long jdField_b_of_type_Long = 9223372036854775807L;
  private int jdField_c_of_type_Int = 60;
  private long jdField_c_of_type_Long = 9223372036854775807L;
  
  public aqag(String paramString, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime());
  }
  
  public static Drawable a(Context paramContext, aqam paramaqam)
  {
    Object localObject = paramaqam.a;
    if ((localObject instanceof MessageForMarketFace))
    {
      paramContext = a((MessageForMarketFace)localObject);
      if (paramContext == null) {
        break label170;
      }
    }
    label170:
    for (paramContext = paramContext.a("fromAIO", true);; paramContext = null)
    {
      paramaqam.c = true;
      URL localURL;
      do
      {
        return paramContext;
        if (!(localObject instanceof MessageForPic)) {
          break;
        }
        localURL = bayu.a((MessageForPic)localObject, 1);
        if (baqn.a(localURL.toString()) != null)
        {
          paramContext = URLDrawable.getDrawable(localURL, a(paramContext, (int)((MessageForPic)localObject).width, (int)((MessageForPic)localObject).height));
          paramaqam.c = true;
          return paramContext;
        }
        localURL = afwu.a((MessageForPic)localObject);
        localObject = URLDrawable.getDrawable(localURL, a(paramContext, ((MessageForPic)localObject).thumbWidth, ((MessageForPic)localObject).thumbHeight));
        paramaqam.c = false;
        paramContext = (Context)localObject;
      } while (!QLog.isColorLevel());
      QLog.d("EmotionDataManager", 2, new Object[] { "init view,big pic not exist:", baqn.a(localURL.toString()) });
      return localObject;
      return null;
    }
  }
  
  public static apxv a(MessageForMarketFace paramMessageForMarketFace)
  {
    return ((aufn)((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getManager(14)).a(paramMessageForMarketFace.mMarkFaceMessage);
  }
  
  private static URLDrawable.URLDrawableOptions a(Context paramContext, int paramInt1, int paramInt2)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mPlayGifImage = true;
    localURLDrawableOptions.mMemoryCacheKeySuffix = "AIOEmotionFragment";
    localURLDrawableOptions.mRequestWidth = paramContext.getResources().getDisplayMetrics().widthPixels;
    localURLDrawableOptions.mRequestHeight = paramContext.getResources().getDisplayMetrics().heightPixels;
    localURLDrawableOptions.mLoadingDrawable = new apkp(paramInt1, paramInt2);
    return localURLDrawableOptions;
  }
  
  public static EmoticonPackage a(String paramString)
  {
    return ((aufn)((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getManager(14)).a(paramString);
  }
  
  private List<MessageRecord> a(List<MessageRecord> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject1 = (MessageRecord)paramList.next();
      if (((MessageRecord)localObject1).shmsgseq < this.jdField_b_of_type_Long) {
        this.jdField_b_of_type_Long = ((MessageRecord)localObject1).shmsgseq;
      }
      if (((MessageRecord)localObject1).versionCode < this.jdField_b_of_type_Int) {
        this.jdField_b_of_type_Int = ((MessageRecord)localObject1).versionCode;
      }
      if ((((MessageRecord)localObject1).getId() > 0L) && (((MessageRecord)localObject1).getId() < this.jdField_a_of_type_Long)) {
        this.jdField_a_of_type_Long = ((MessageRecord)localObject1).getId();
      }
      if (((MessageRecord)localObject1).time < this.jdField_c_of_type_Long) {
        this.jdField_c_of_type_Long = ((MessageRecord)localObject1).time;
      }
      Object localObject2;
      if ((localObject1 instanceof MessageForPic))
      {
        localObject2 = (MessageForPic)localObject1;
        ((MessageForPic)localObject2).parse();
        if ((!a((MessageForPic)localObject2)) && (afwu.a((MessageForPic)localObject2))) {
          localArrayList.add(localObject1);
        }
      }
      else if ((localObject1 instanceof MessageForMarketFace))
      {
        localArrayList.add(localObject1);
      }
      else if ((localObject1 instanceof MessageForMixedMsg))
      {
        localObject1 = (MessageForMixedMsg)localObject1;
        if (((MessageForMixedMsg)localObject1).msgElemList != null)
        {
          localObject1 = ((MessageForMixedMsg)localObject1).msgElemList.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (MessageRecord)((Iterator)localObject1).next();
            if ((localObject2 instanceof MessageForPic))
            {
              localObject2 = (MessageForPic)localObject2;
              ((MessageForPic)localObject2).parse();
              if (afwu.a((MessageForPic)localObject2)) {
                localArrayList.add(localObject2);
              }
            }
          }
        }
      }
    }
    return localArrayList;
  }
  
  private void a()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 9223372036854775807L;
    this.jdField_b_of_type_Long = 9223372036854775807L;
    this.jdField_b_of_type_Int = 3;
    this.jdField_c_of_type_Long = 9223372036854775807L;
    this.jdField_c_of_type_Int = 60;
  }
  
  public List<MessageRecord> a(String paramString, int paramInt, boolean paramBoolean)
  {
    return a(paramString, paramInt, paramBoolean, -1L);
  }
  
  public List<MessageRecord> a(String paramString, int paramInt, boolean paramBoolean, long paramLong)
  {
    ArrayList localArrayList;
    for (;;)
    {
      try
      {
        if ((!paramString.equals(this.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_Int != paramInt)) {
          break label480;
        }
        if (paramBoolean) {
          a();
        }
        if (this.jdField_c_of_type_Int < 60) {
          return null;
        }
        if (QLog.isColorLevel()) {
          QLog.d("EmotionDataManager", 2, "getEmotionDataIncremental start");
        }
        long l = System.currentTimeMillis();
        localArrayList = new ArrayList();
        if (paramLong != -1L)
        {
          paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
          if (paramString != null) {
            localArrayList.addAll(a(paramString.a(paramLong)));
          }
          if (!QLog.isColorLevel()) {
            break label482;
          }
          paramInt = localArrayList.size();
          if (paramString != null) {
            break label485;
          }
          paramBoolean = true;
          QLog.d("EmotionDataManager", 2, new Object[] { "getEmotionDataIncremental end, tempList.size: ", Integer.valueOf(paramInt), "  ", Boolean.valueOf(paramBoolean) });
          break label482;
        }
        int[] arrayOfInt = new int[4];
        int[] tmp175_173 = arrayOfInt;
        tmp175_173[0] = -2007;
        int[] tmp181_175 = tmp175_173;
        tmp181_175[1] = -20000;
        int[] tmp187_181 = tmp181_175;
        tmp187_181[2] = -2000;
        int[] tmp193_187 = tmp187_181;
        tmp193_187[3] = -1035;
        tmp193_187;
        if (!this.jdField_a_of_type_Boolean)
        {
          List localList2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).a(paramString, paramInt, tmp181_175);
          localList1 = localList2;
          if (localList2.size() < 60)
          {
            localList1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt, tmp181_175, 60);
            this.jdField_c_of_type_Int = localList1.size();
          }
          if (!this.jdField_a_of_type_Boolean) {
            this.jdField_a_of_type_Boolean = true;
          }
          tmp175_173.addAll(0, a(localList1));
          if ((tmp175_173.size() < 30) && (this.jdField_c_of_type_Int >= 60)) {
            continue;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("EmotionDataManager", 2, "getEmotionDataIncremental end, tempList.size: " + tmp175_173.size() + ", cost:" + (System.currentTimeMillis() - l));
          break;
        }
        if (abti.a(paramInt))
        {
          this.jdField_b_of_type_Long -= 1L;
          localList1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt, this.jdField_a_of_type_Long, this.jdField_b_of_type_Int, this.jdField_b_of_type_Long, tmp181_175, 60);
          this.jdField_c_of_type_Int = localList1.size();
          continue;
        }
        List localList1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt, this.jdField_a_of_type_Long, this.jdField_b_of_type_Int, this.jdField_c_of_type_Long, tmp181_175, 60);
      }
      catch (OutOfMemoryError paramString)
      {
        QLog.e("EmotionDataManager", 2, "out of memory", paramString);
        return null;
      }
      continue;
      label480:
      return null;
      label482:
      return tmp175_173;
      label485:
      paramBoolean = false;
    }
    return tmp175_173;
  }
  
  public boolean a(MessageForPic paramMessageForPic)
  {
    return ahbf.a(paramMessageForPic);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqag
 * JD-Core Version:    0.7.0.1
 */