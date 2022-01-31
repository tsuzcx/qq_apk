import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
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

public class annf
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = 9223372036854775807L;
  private String jdField_a_of_type_JavaLangString;
  private volatile boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 3;
  private long jdField_b_of_type_Long = 9223372036854775807L;
  private volatile boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 60;
  private long jdField_c_of_type_Long = 9223372036854775807L;
  
  public annf(String paramString, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public static Drawable a(Context paramContext, annl paramannl)
  {
    Object localObject = paramannl.a;
    if ((localObject instanceof MessageForMarketFace))
    {
      paramContext = a((MessageForMarketFace)localObject);
      if (paramContext == null) {
        break label140;
      }
    }
    label140:
    for (paramContext = paramContext.a("fromAIO", true);; paramContext = null)
    {
      paramannl.c = true;
      URL localURL;
      do
      {
        return paramContext;
        if (!(localObject instanceof MessageForPic)) {
          break;
        }
        localURL = axwd.a((MessageForPic)localObject, 1);
        if (axoa.a(localURL.toString()) != null)
        {
          paramContext = URLDrawable.getDrawable(localURL, a(paramContext));
          paramannl.c = true;
          return paramContext;
        }
        localURL = adkt.a((MessageForPic)localObject);
        localObject = URLDrawable.getDrawable(localURL, a(paramContext));
        paramannl.c = false;
        paramContext = (Context)localObject;
      } while (!QLog.isColorLevel());
      QLog.d("EmotionDataManager", 2, new Object[] { "init view,big pic not exist:", axoa.a(localURL.toString()) });
      return localObject;
      return null;
    }
  }
  
  public static anla a(MessageForMarketFace paramMessageForMarketFace)
  {
    return ((arnz)((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getManager(14)).a(paramMessageForMarketFace.mMarkFaceMessage);
  }
  
  private static URLDrawable.URLDrawableOptions a(Context paramContext)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mPlayGifImage = true;
    localURLDrawableOptions.mMemoryCacheKeySuffix = "AIOEmotionFragment";
    localURLDrawableOptions.mRequestWidth = paramContext.getResources().getDisplayMetrics().widthPixels;
    localURLDrawableOptions.mRequestHeight = paramContext.getResources().getDisplayMetrics().heightPixels;
    localURLDrawableOptions.mLoadingDrawable = axwd.a;
    return localURLDrawableOptions;
  }
  
  public static EmoticonPackage a(String paramString)
  {
    return ((arnz)((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getManager(14)).a(paramString);
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
        if ((!aeor.a((MessageForPic)localObject2)) && (adkt.a((MessageForPic)localObject2))) {
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
              if (adkt.a((MessageForPic)localObject2)) {
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
    this.jdField_b_of_type_Boolean = false;
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
    for (;;)
    {
      try
      {
        if (paramString.equals(this.jdField_a_of_type_JavaLangString))
        {
          i = this.jdField_a_of_type_Int;
          if (i == paramInt) {}
        }
        else
        {
          return null;
        }
        if (paramBoolean) {
          a();
        }
        int i = this.jdField_c_of_type_Int;
        if (i < 60) {
          return null;
        }
        if (QLog.isColorLevel()) {
          QLog.d("EmotionDataManager", 2, "getEmotionDataIncremental start");
        }
        long l = System.currentTimeMillis();
        this.jdField_b_of_type_Boolean = true;
        localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
        ArrayList localArrayList = new ArrayList();
        if (paramLong != -1L)
        {
          paramString = localQQAppInterface.a();
          if (paramString != null) {
            localArrayList.addAll(a(paramString.a(paramLong)));
          }
          if (QLog.isColorLevel())
          {
            paramInt = localArrayList.size();
            if (paramString == null)
            {
              paramBoolean = true;
              QLog.d("EmotionDataManager", 2, new Object[] { "getEmotionDataIncremental end, tempList.size: ", Integer.valueOf(paramInt), "  ", Boolean.valueOf(paramBoolean) });
            }
          }
          else
          {
            return localArrayList;
          }
          paramBoolean = false;
          continue;
        }
        arrayOfInt = new int[4];
        int[] tmp215_213 = arrayOfInt;
        tmp215_213[0] = -2007;
        int[] tmp221_215 = tmp215_213;
        tmp221_215[1] = -20000;
        int[] tmp227_221 = tmp221_215;
        tmp227_221[2] = -2000;
        int[] tmp233_227 = tmp227_221;
        tmp233_227[3] = -1035;
        tmp233_227;
        if (!this.jdField_a_of_type_Boolean)
        {
          List localList2 = tmp215_213.a(paramInt).a(paramString, paramInt, tmp221_215);
          localList1 = localList2;
          if (localList2.size() < 60)
          {
            localList1 = tmp215_213.a().a(paramString, paramInt, tmp221_215, 60);
            this.jdField_c_of_type_Int = localList1.size();
          }
          if (!this.jdField_a_of_type_Boolean) {
            this.jdField_a_of_type_Boolean = true;
          }
          localArrayList.addAll(0, a(localList1));
          if ((localArrayList.size() < 30) && (this.jdField_c_of_type_Int >= 60)) {
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.d("EmotionDataManager", 2, "getEmotionDataIncremental end, tempList.size: " + localArrayList.size() + ", cost:" + (System.currentTimeMillis() - l));
          }
          return localArrayList;
        }
        if (!akbj.a(paramInt)) {
          continue;
        }
        this.jdField_b_of_type_Long -= 1L;
        localList1 = tmp215_213.a().a(paramString, paramInt, this.jdField_a_of_type_Long, this.jdField_b_of_type_Int, this.jdField_b_of_type_Long, tmp221_215, 60);
      }
      catch (OutOfMemoryError paramString)
      {
        QQAppInterface localQQAppInterface;
        int[] arrayOfInt;
        QLog.e("EmotionDataManager", 2, "out of memory", paramString);
        return null;
        List localList1 = tmp215_213.a().a(paramString, paramInt, this.jdField_a_of_type_Long, this.jdField_b_of_type_Int, this.jdField_c_of_type_Long, tmp221_215, 60);
        continue;
      }
      finally
      {
        this.jdField_b_of_type_Boolean = false;
      }
      this.jdField_c_of_type_Int = localList1.size();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     annf
 * JD-Core Version:    0.7.0.1
 */