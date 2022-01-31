import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionBase;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;

class apos
  extends apsc
{
  apos(apoo paramapoo) {}
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt, Bundle paramBundle)
  {
    if (!this.a.jdField_a_of_type_JavaUtilMap.containsKey(paramEmoticonPackage.epId)) {}
    Object localObject1;
    ArrayList localArrayList;
    Object localObject2;
    int i;
    do
    {
      return;
      localObject1 = (apro)apoo.l(this.a).getManager(43);
      if (paramInt != 0) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("FavroamingManager", 2, "onJsonComplete, start download fav emoticon: " + paramEmoticonPackage.epId);
      }
      paramInt = paramBundle.getInt("jsonType", apro.c);
      paramBundle = new File(apvx.r.replace("[epId]", paramEmoticonPackage.epId));
      localArrayList = new ArrayList();
      localObject2 = new apsq();
      if (paramBundle.exists()) {}
      for (paramBundle = bdhb.a(paramBundle);; paramBundle = null)
      {
        paramBundle = apsd.a(apoo.m(this.a), paramEmoticonPackage, paramInt, paramBundle, localArrayList, (apsq)localObject2);
        if (paramBundle == null) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("FavroamingManager", 2, "parse Json Error:" + paramBundle);
        }
        bdva.a("emotionType", "emotionActionFav", "2", paramEmoticonPackage.epId, "", "", paramBundle, "", "", "");
        return;
      }
      if ((!((apsq)localObject2).jdField_a_of_type_Boolean) && (paramEmoticonPackage.jobType != 4))
      {
        paramInt = 0;
        do
        {
          ((apsq)localObject2).jdField_a_of_type_JavaLangString = null;
          if (QLog.isColorLevel()) {
            QLog.d("FavroamingManager", 2, "addEmoticonsTask| fetchEncryptKeys count=" + paramInt);
          }
          ((apro)localObject1).a(paramEmoticonPackage.epId, localArrayList, (apsq)localObject2);
          i = paramInt + 1;
          if (((apsq)localObject2).jdField_a_of_type_Boolean) {
            break;
          }
          paramInt = i;
        } while (i < 3);
        if (QLog.isColorLevel()) {
          QLog.d("FavroamingManager", 2, "addEmoticonsTask| fetchEncryptKeys count=" + i + " encryptKeysSuccess=" + ((apsq)localObject2).jdField_a_of_type_Boolean);
        }
      }
      localArrayList = (ArrayList)this.a.jdField_a_of_type_JavaUtilMap.get(paramEmoticonPackage.epId);
    } while (localArrayList == null);
    if (paramEmoticonPackage.jobType == 0)
    {
      paramInt = 0;
      label388:
      if (paramInt < localArrayList.size())
      {
        localObject2 = (CustomEmotionData)localArrayList.get(paramInt);
        if (localObject2 != null) {
          break label420;
        }
      }
      for (;;)
      {
        label413:
        paramInt += 1;
        break label388;
        break;
        label420:
        paramBundle = new Emoticon();
        if (apoo.n(this.a) != null) {
          break label459;
        }
        QLog.i("FavroamingManager", 1, "downloadAIOEmoticon|app null");
        this.a.a((CustomEmotionData)localObject2, false);
      }
      label459:
      aufn localaufn = (aufn)apoo.o(this.a).getManager(14);
      if (localaufn == null) {
        break label911;
      }
      paramBundle = localaufn.a(((CustomEmotionData)localObject2).emoPath, ((CustomEmotionData)localObject2).eId);
    }
    label911:
    for (;;)
    {
      if (paramBundle == null)
      {
        QLog.i("FavroamingManager", 1, "downloadAIOEmoticon|cannot find emoticon: epId:" + paramEmoticonPackage.epId + "，eid=" + ((CustomEmotionData)localObject2).eId);
        ((CustomEmotionData)localObject2).RomaingType = "needDel";
        ((apon)apoo.p(this.a).getManager(149)).b((CustomEmotionBase)localObject2);
        this.a.a((CustomEmotionData)localArrayList.get(paramInt), false);
        break label413;
      }
      if (QLog.isColorLevel()) {
        QLog.d("FavroamingManager", 2, "downloadAIOEmoticon|taskvalue:" + 14 + "，epid:" + paramBundle.epId + "，eid=" + paramBundle.eId);
      }
      if (((apro)localObject1).a(paramBundle, 14))
      {
        this.a.a((CustomEmotionData)localArrayList.get(paramInt), true);
        break label413;
      }
      this.a.a((CustomEmotionData)localArrayList.get(paramInt), false);
      break label413;
      if ((paramEmoticonPackage.jobType != 3) && (paramEmoticonPackage.jobType != 5)) {
        break;
      }
      aprn.a().a(this.a.jdField_a_of_type_Apsb);
      ((apro)localObject1).a(paramEmoticonPackage, false);
      return;
      paramBundle = (ArrayList)this.a.jdField_a_of_type_JavaUtilMap.get(paramEmoticonPackage.epId);
      if (paramBundle != null)
      {
        i = 0;
        while (i < paramBundle.size())
        {
          localObject1 = (CustomEmotionData)paramBundle.get(i);
          if (localObject1 != null) {
            this.a.a((CustomEmotionData)localObject1, false);
          }
          i += 1;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("FavroamingManager", 2, "downloadAIOEmoticon fail epId:" + paramEmoticonPackage.epId);
      }
      bdva.a("emotionType", "emotionActionFav", "1", paramEmoticonPackage.epId, "", bdin.b(apoo.q(this.a).getApplication()) + "", paramInt + "", "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apos
 * JD-Core Version:    0.7.0.1
 */