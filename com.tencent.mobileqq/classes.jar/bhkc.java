import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import dov.com.qq.im.capture.paster.PasterDataManager.1;
import dov.com.qq.im.capture.view.StaticStickerProviderView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiItem;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class bhkc
  extends bhgm
  implements IEventReceiver, spg<sqx>, sse
{
  public static AtomicBoolean a;
  private Context jdField_a_of_type_AndroidContentContext;
  protected Handler a;
  private bhkg jdField_a_of_type_Bhkg;
  protected bier a;
  public bikx a;
  protected bioo a;
  protected biou a;
  protected Runnable a;
  public CopyOnWriteArrayList<bion> a;
  private squ jdField_a_of_type_Squ;
  public ssf a;
  public boolean a;
  private boolean b;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  public bhkc()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_Ssf = null;
    this.jdField_a_of_type_JavaLangRunnable = new PasterDataManager.1(this);
    this.jdField_a_of_type_Bikx = new bhkd(this);
  }
  
  private void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((paramString1 != null) && (this.jdField_a_of_type_Bioo != null) && (!paramString1.equals(this.jdField_a_of_type_Bioo.g))) {
      this.jdField_a_of_type_Bioo.g = paramString1;
    }
    if ((paramString2 != null) && (this.jdField_a_of_type_Biou != null) && (!paramString2.equals(this.jdField_a_of_type_Biou.f))) {}
    for (int i = 1;; i = 0)
    {
      if ((this.jdField_a_of_type_Biou != null) && (i != 0))
      {
        this.jdField_a_of_type_Biou.f = paramString2;
        paramString1 = this.jdField_a_of_type_Biou.jdField_a_of_type_JavaUtilList.iterator();
        while (paramString1.hasNext()) {
          ((biov)paramString1.next()).jdField_b_of_type_JavaLangString = paramString2;
        }
        if (paramBoolean) {
          this.jdField_a_of_type_Bier.a(this.jdField_a_of_type_Biou);
        }
      }
      if (this.jdField_a_of_type_Bioo != null)
      {
        if (i != 0)
        {
          this.jdField_a_of_type_Bioo.f = paramString2;
          paramString1 = this.jdField_a_of_type_Bioo.jdField_a_of_type_JavaUtilList.iterator();
          while (paramString1.hasNext())
          {
            bior localbior = (bior)paramString1.next();
            if (localbior.jdField_a_of_type_Boolean) {
              localbior.l = paramString2;
            }
          }
        }
        paramString1 = this.jdField_a_of_type_Bioo.jdField_a_of_type_JavaUtilList.iterator();
        while (paramString1.hasNext())
        {
          paramString2 = (bior)paramString1.next();
          if ((paramString2.jdField_a_of_type_Int == 7) && (!this.jdField_a_of_type_Bioo.g.equals(paramString2.i)) && (this.jdField_a_of_type_Bioo.jdField_a_of_type_JavaUtilMap != null)) {
            a(this.jdField_a_of_type_Bioo.jdField_a_of_type_JavaUtilMap, this.jdField_a_of_type_Bioo.g, paramString2);
          }
        }
        if (paramBoolean) {
          this.jdField_a_of_type_Bier.a(this.jdField_a_of_type_Bioo);
        }
      }
      return;
    }
  }
  
  private void a(Map<String, Map<String, biop>> paramMap, String paramString, bior parambior)
  {
    if (parambior.a() != null) {
      parambior.a().c();
    }
    Map localMap = (Map)paramMap.get(parambior.h);
    if (localMap != null)
    {
      paramMap = (biop)localMap.get(paramString);
      if (paramMap != null) {
        break label94;
      }
      paramMap = (biop)localMap.get("default");
    }
    label94:
    for (;;)
    {
      if (paramMap != null)
      {
        parambior.g = paramMap.jdField_a_of_type_JavaLangString;
        parambior.e = paramMap.jdField_b_of_type_JavaLangString;
        parambior.f = paramMap.c;
      }
      return;
    }
  }
  
  private void a(sqx paramsqx)
  {
    if (paramsqx != null)
    {
      this.jdField_a_of_type_Bioo.c = paramsqx.jdField_a_of_type_Int;
      if (paramsqx.jdField_a_of_type_JavaLangString != null)
      {
        paramsqx = paramsqx.jdField_a_of_type_JavaLangString.split("\\|");
        if ((paramsqx != null) && (paramsqx.length == 2))
        {
          this.jdField_a_of_type_Bioo.h = paramsqx[0];
          this.jdField_a_of_type_Bioo.i = paramsqx[1];
        }
        paramsqx = this.jdField_a_of_type_Bioo.jdField_a_of_type_JavaUtilList.iterator();
        while (paramsqx.hasNext())
        {
          bior localbior = (bior)paramsqx.next();
          if (localbior.jdField_a_of_type_Int == 6)
          {
            localbior.j = this.jdField_a_of_type_Bioo.h;
            localbior.k = this.jdField_a_of_type_Bioo.i;
            localbior.c = this.jdField_a_of_type_Bioo.c;
          }
        }
      }
    }
  }
  
  private void a(sry paramsry, boolean paramBoolean)
  {
    urk.b("PasterDataManager", "requestPoiList");
    srz localsrz = (srz)sqg.a(9);
    sry localsry = paramsry;
    if (paramsry == null) {
      localsry = srz.a();
    }
    if (paramBoolean)
    {
      localsrz.a(localsry, null, this);
      return;
    }
    localsrz.a(localsry, this.jdField_a_of_type_Ssf, this);
  }
  
  private void a(boolean paramBoolean)
  {
    a(null, paramBoolean);
  }
  
  private static void b(biox parambiox, DoodleEmojiItem paramDoodleEmojiItem)
  {
    parambiox.jdField_b_of_type_JavaLangString = paramDoodleEmojiItem.name;
    parambiox.c = paramDoodleEmojiItem.icon;
    parambiox.d = paramDoodleEmojiItem.download_icon;
    parambiox.g = paramDoodleEmojiItem.getLocalEmojiFolderPath();
    parambiox.e = paramDoodleEmojiItem.download_wording;
    parambiox.jdField_a_of_type_Boolean = "1".equals(paramDoodleEmojiItem.random_position);
    parambiox.a(paramDoodleEmojiItem.config);
    parambiox.jdField_a_of_type_Int = paramDoodleEmojiItem.hide;
    parambiox.jdField_b_of_type_Int = paramDoodleEmojiItem.mask;
  }
  
  private void d()
  {
    Object localObject = (bikm)sqg.a(39);
    ((bikm)localObject).c();
    String str;
    if (this.jdField_a_of_type_Biou == null)
    {
      this.jdField_a_of_type_Biou = new biou("0");
      this.jdField_a_of_type_Biou.jdField_b_of_type_Boolean = true;
      str = bikm.c((bikm)localObject, "0");
      localObject = bikm.a((bikm)localObject, "0");
      if ((TextUtils.isEmpty((CharSequence)localObject)) || (!badq.g(this.jdField_a_of_type_AndroidContentContext))) {
        break label113;
      }
      this.jdField_a_of_type_Biou.c = ((String)localObject);
    }
    for (;;)
    {
      this.jdField_a_of_type_Biou.a(str);
      if (this.jdField_a_of_type_Bioo == null) {
        this.jdField_a_of_type_Bioo = new bioo("2001");
      }
      return;
      label113:
      this.jdField_a_of_type_Biou.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845513);
    }
  }
  
  public bier a()
  {
    return this.jdField_a_of_type_Bier;
  }
  
  public bion a(String paramString)
  {
    return this.jdField_a_of_type_Bier.a(paramString);
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Biou != null) {
      return this.jdField_a_of_type_Biou.f;
    }
    return null;
  }
  
  public List<bion> a()
  {
    return a(false);
  }
  
  @NonNull
  public List<bion> a(boolean paramBoolean)
  {
    for (;;)
    {
      DoodleEmojiItem localDoodleEmojiItem;
      Object localObject3;
      try
      {
        if ((this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null) && (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() != 0)) {
          break label752;
        }
        Object localObject1 = ((bikm)sqg.a(39)).a();
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
        localObject1 = ((Collection)localObject1).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localDoodleEmojiItem = (DoodleEmojiItem)((Iterator)localObject1).next();
        if (localDoodleEmojiItem.type == 1)
        {
          localObject3 = new biox(localDoodleEmojiItem.pack_id);
          b((biox)localObject3, localDoodleEmojiItem);
          if (("1".equals(((biox)localObject3).jdField_a_of_type_JavaLangString)) && (!badq.g(this.jdField_a_of_type_AndroidContentContext))) {
            ((biox)localObject3).jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845369);
          }
          this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(localObject3);
          continue;
        }
        if (localDoodleEmojiItem.type != 2) {
          break label398;
        }
      }
      finally {}
      this.jdField_a_of_type_Biou.jdField_b_of_type_JavaLangString = localDoodleEmojiItem.name;
      if ((!TextUtils.isEmpty(localDoodleEmojiItem.icon)) && (badq.g(this.jdField_a_of_type_AndroidContentContext))) {
        this.jdField_a_of_type_Biou.c = localDoodleEmojiItem.icon;
      }
      Object localObject4;
      while (localDoodleEmojiItem.mItemList != null)
      {
        this.jdField_a_of_type_Biou.jdField_a_of_type_JavaUtilList = localDoodleEmojiItem.mItemList;
        if (localDoodleEmojiItem.mItemList == null) {
          break;
        }
        urk.b("PasterDataManager", "add doodle emoji location item name = " + this.jdField_a_of_type_Biou.f);
        localObject3 = localDoodleEmojiItem.mItemList.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (biov)((Iterator)localObject3).next();
          ((biov)localObject4).g = this.jdField_a_of_type_Biou.jdField_b_of_type_JavaLangString;
          ((biov)localObject4).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Biou.f;
        }
        this.jdField_a_of_type_Biou.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845513);
      }
      this.jdField_a_of_type_Biou.jdField_a_of_type_Boolean = "1".equals(localDoodleEmojiItem.random_position);
      this.jdField_a_of_type_Biou.jdField_a_of_type_Int = localDoodleEmojiItem.hide;
      this.jdField_a_of_type_Biou.jdField_b_of_type_Int = localDoodleEmojiItem.mask;
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(this.jdField_a_of_type_Biou);
      continue;
      label398:
      if (localDoodleEmojiItem.type == 3)
      {
        if (this.jdField_a_of_type_Bioo == null) {
          this.jdField_a_of_type_Bioo = new bioo(localDoodleEmojiItem.pack_id);
        }
        for (;;)
        {
          this.jdField_a_of_type_Bioo.jdField_b_of_type_JavaLangString = localDoodleEmojiItem.name;
          this.jdField_a_of_type_Bioo.jdField_a_of_type_JavaUtilList = localDoodleEmojiItem.mInfoItemList;
          this.jdField_a_of_type_Bioo.a(localDoodleEmojiItem.config);
          this.jdField_a_of_type_Bioo.jdField_a_of_type_Int = localDoodleEmojiItem.hide;
          this.jdField_a_of_type_Bioo.g = "default";
          this.jdField_a_of_type_Bioo.c = -999;
          this.jdField_a_of_type_Bioo.h = "--";
          this.jdField_a_of_type_Bioo.i = "default";
          if (this.jdField_a_of_type_Bioo.jdField_a_of_type_JavaUtilList == null) {
            break;
          }
          localObject3 = this.jdField_a_of_type_Bioo.jdField_a_of_type_JavaUtilList.iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (bior)((Iterator)localObject3).next();
            ((bior)localObject4).m = this.jdField_a_of_type_Bioo.jdField_b_of_type_JavaLangString;
            if (bios.a(((bior)localObject4).jdField_a_of_type_Int)) {
              ((bior)localObject4).l = this.jdField_a_of_type_Bioo.f;
            }
            if ((localDoodleEmojiItem.mCityRes != null) && (((bior)localObject4).jdField_a_of_type_Int == 7)) {
              a(localDoodleEmojiItem.mCityRes, this.jdField_a_of_type_Bioo.g, (bior)localObject4);
            }
            if (((bior)localObject4).jdField_a_of_type_Int == 6)
            {
              ((bior)localObject4).c = this.jdField_a_of_type_Bioo.c;
              ((bior)localObject4).j = this.jdField_a_of_type_Bioo.h;
              ((bior)localObject4).k = this.jdField_a_of_type_Bioo.i;
            }
          }
          this.jdField_a_of_type_Bioo.jdField_a_of_type_JavaLangString = localDoodleEmojiItem.pack_id;
        }
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(this.jdField_a_of_type_Bioo);
        this.jdField_a_of_type_Bioo.jdField_a_of_type_JavaUtilMap = localDoodleEmojiItem.mCityRes;
      }
    }
    urk.b("PasterDataManager", "getDoodleFacePackages, size = " + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    label752:
    if (paramBoolean)
    {
      StaticStickerProviderView.a(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList);
      jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    }
    CopyOnWriteArrayList localCopyOnWriteArrayList = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
    return localCopyOnWriteArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.getContext();
    this.jdField_a_of_type_Bier = new bier();
    d();
    this.jdField_a_of_type_Bhkg = new bhkg(this);
    sgi.a().registerSubscriber(this.jdField_a_of_type_Bhkg);
    if (QLog.isDevelopLevel()) {
      QLog.d("PasterDataManager", 4, "initPasterConfig");
    }
  }
  
  public void a(int paramInt, ssf paramssf, List<TroopBarPOI> paramList)
  {
    urk.b("PasterDataManager", "onPOIListRequestResult." + paramInt);
    if ((paramInt == 0) && (paramssf != null))
    {
      this.jdField_a_of_type_Ssf = paramssf;
      if ((paramList != null) && (paramList.size() > 0))
      {
        paramssf = ((TroopBarPOI)paramList.get(0)).a();
        if (QLog.isColorLevel()) {
          QLog.d("PasterDataManager", 2, "onPOIListRequestResult " + paramssf);
        }
        String str = ShortVideoUtils.c(QQStoryContext.a().getCurrentAccountUin());
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext()) {
          if (((TroopBarPOI)localIterator.next()).a().equals(str)) {
            paramssf = str;
          }
        }
      }
    }
    for (;;)
    {
      a(((TroopBarPOI)paramList.get(0)).jdField_b_of_type_JavaLangString, paramssf, true);
      return;
    }
  }
  
  public void a(String paramString)
  {
    a(null, paramString, false);
  }
  
  public void a(sry paramsry)
  {
    this.jdField_a_of_type_Squ = ((squ)((sph)sqg.a(20)).a(0));
    Object localObject = this.jdField_a_of_type_Squ.a();
    if (localObject != null)
    {
      urk.b("PasterDataManager", "get weather from cache.");
      a((sqx)localObject);
      return;
    }
    urk.b("PasterDataManager", "get weather from net.");
    localObject = paramsry;
    if (paramsry == null) {
      localObject = srz.a();
    }
    this.jdField_a_of_type_Squ.a(this);
    this.jdField_a_of_type_Squ.b((sry)localObject);
  }
  
  public void a(boolean paramBoolean, Activity paramActivity)
  {
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Bioo != null) && (!"default".equals(this.jdField_a_of_type_Bioo.g)) && (!"--".equals(this.jdField_a_of_type_Bioo.h))) {
      return;
    }
    new auua(paramActivity, new bhke(this, paramBoolean)).a();
  }
  
  public void a(boolean paramBoolean, sqx paramsqx)
  {
    if (paramBoolean) {
      a(paramsqx);
    }
  }
  
  public void aZ_()
  {
    if (this.jdField_a_of_type_Bhkg != null)
    {
      sgi.a().unRegisterSubscriber(this.jdField_a_of_type_Bhkg);
      this.jdField_a_of_type_Bhkg = null;
    }
    if (this.jdField_a_of_type_Squ != null) {
      this.jdField_a_of_type_Squ.b(this);
    }
  }
  
  public void c()
  {
    this.jdField_b_of_type_Boolean = false;
  }
  
  public boolean isValidate()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhkc
 * JD-Core Version:    0.7.0.1
 */