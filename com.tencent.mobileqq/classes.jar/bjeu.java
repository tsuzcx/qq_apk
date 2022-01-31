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

public class bjeu
  extends bjbe
  implements IEventReceiver, tcc<tdt>, tfa
{
  public static AtomicBoolean a;
  private Context jdField_a_of_type_AndroidContentContext;
  protected Handler a;
  private bjey jdField_a_of_type_Bjey;
  protected bjvo a;
  public bkbs a;
  protected bkfj a;
  protected bkfp a;
  protected Runnable a;
  public CopyOnWriteArrayList<bkfi> a;
  private tdq jdField_a_of_type_Tdq;
  public tfb a;
  public boolean a;
  private boolean b;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  public bjeu()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_Tfb = null;
    this.jdField_a_of_type_JavaLangRunnable = new PasterDataManager.1(this);
    this.jdField_a_of_type_Bkbs = new bjev(this);
  }
  
  private void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((paramString1 != null) && (this.jdField_a_of_type_Bkfj != null) && (!paramString1.equals(this.jdField_a_of_type_Bkfj.g))) {
      this.jdField_a_of_type_Bkfj.g = paramString1;
    }
    if ((paramString2 != null) && (this.jdField_a_of_type_Bkfp != null) && (!paramString2.equals(this.jdField_a_of_type_Bkfp.f))) {}
    for (int i = 1;; i = 0)
    {
      if ((this.jdField_a_of_type_Bkfp != null) && (i != 0))
      {
        this.jdField_a_of_type_Bkfp.f = paramString2;
        paramString1 = this.jdField_a_of_type_Bkfp.jdField_a_of_type_JavaUtilList.iterator();
        while (paramString1.hasNext()) {
          ((bkfq)paramString1.next()).jdField_b_of_type_JavaLangString = paramString2;
        }
        if (paramBoolean) {
          this.jdField_a_of_type_Bjvo.a(this.jdField_a_of_type_Bkfp);
        }
      }
      if (this.jdField_a_of_type_Bkfj != null)
      {
        if (i != 0)
        {
          this.jdField_a_of_type_Bkfj.f = paramString2;
          paramString1 = this.jdField_a_of_type_Bkfj.jdField_a_of_type_JavaUtilList.iterator();
          while (paramString1.hasNext())
          {
            bkfm localbkfm = (bkfm)paramString1.next();
            if (localbkfm.jdField_a_of_type_Boolean) {
              localbkfm.l = paramString2;
            }
          }
        }
        paramString1 = this.jdField_a_of_type_Bkfj.jdField_a_of_type_JavaUtilList.iterator();
        while (paramString1.hasNext())
        {
          paramString2 = (bkfm)paramString1.next();
          if ((paramString2.jdField_a_of_type_Int == 7) && (!this.jdField_a_of_type_Bkfj.g.equals(paramString2.i)) && (this.jdField_a_of_type_Bkfj.jdField_a_of_type_JavaUtilMap != null)) {
            a(this.jdField_a_of_type_Bkfj.jdField_a_of_type_JavaUtilMap, this.jdField_a_of_type_Bkfj.g, paramString2);
          }
        }
        if (paramBoolean) {
          this.jdField_a_of_type_Bjvo.a(this.jdField_a_of_type_Bkfj);
        }
      }
      return;
    }
  }
  
  private void a(Map<String, Map<String, bkfk>> paramMap, String paramString, bkfm parambkfm)
  {
    if (parambkfm.a() != null) {
      parambkfm.a().c();
    }
    Map localMap = (Map)paramMap.get(parambkfm.h);
    if (localMap != null)
    {
      paramMap = (bkfk)localMap.get(paramString);
      if (paramMap != null) {
        break label94;
      }
      paramMap = (bkfk)localMap.get("default");
    }
    label94:
    for (;;)
    {
      if (paramMap != null)
      {
        parambkfm.g = paramMap.jdField_a_of_type_JavaLangString;
        parambkfm.e = paramMap.jdField_b_of_type_JavaLangString;
        parambkfm.f = paramMap.c;
      }
      return;
    }
  }
  
  private void a(tdt paramtdt)
  {
    if (paramtdt != null)
    {
      this.jdField_a_of_type_Bkfj.c = paramtdt.jdField_a_of_type_Int;
      if (paramtdt.jdField_a_of_type_JavaLangString != null)
      {
        paramtdt = paramtdt.jdField_a_of_type_JavaLangString.split("\\|");
        if ((paramtdt != null) && (paramtdt.length == 2))
        {
          this.jdField_a_of_type_Bkfj.h = paramtdt[0];
          this.jdField_a_of_type_Bkfj.i = paramtdt[1];
        }
        paramtdt = this.jdField_a_of_type_Bkfj.jdField_a_of_type_JavaUtilList.iterator();
        while (paramtdt.hasNext())
        {
          bkfm localbkfm = (bkfm)paramtdt.next();
          if (localbkfm.jdField_a_of_type_Int == 6)
          {
            localbkfm.j = this.jdField_a_of_type_Bkfj.h;
            localbkfm.k = this.jdField_a_of_type_Bkfj.i;
            localbkfm.c = this.jdField_a_of_type_Bkfj.c;
          }
        }
      }
    }
  }
  
  private void a(teu paramteu, boolean paramBoolean)
  {
    veg.b("PasterDataManager", "requestPoiList");
    tev localtev = (tev)tdc.a(9);
    teu localteu = paramteu;
    if (paramteu == null) {
      localteu = tev.a();
    }
    if (paramBoolean)
    {
      localtev.a(localteu, null, this);
      return;
    }
    localtev.a(localteu, this.jdField_a_of_type_Tfb, this);
  }
  
  private void a(boolean paramBoolean)
  {
    a(null, paramBoolean);
  }
  
  private static void b(bkfs parambkfs, DoodleEmojiItem paramDoodleEmojiItem)
  {
    parambkfs.jdField_b_of_type_JavaLangString = paramDoodleEmojiItem.name;
    parambkfs.c = paramDoodleEmojiItem.icon;
    parambkfs.d = paramDoodleEmojiItem.download_icon;
    parambkfs.g = paramDoodleEmojiItem.getLocalEmojiFolderPath();
    parambkfs.e = paramDoodleEmojiItem.download_wording;
    parambkfs.jdField_a_of_type_Boolean = "1".equals(paramDoodleEmojiItem.random_position);
    parambkfs.a(paramDoodleEmojiItem.config);
    parambkfs.jdField_a_of_type_Int = paramDoodleEmojiItem.hide;
    parambkfs.jdField_b_of_type_Int = paramDoodleEmojiItem.mask;
  }
  
  private void e()
  {
    Object localObject = (bkbh)tdc.a(39);
    ((bkbh)localObject).c();
    String str;
    if (this.jdField_a_of_type_Bkfp == null)
    {
      this.jdField_a_of_type_Bkfp = new bkfp("0");
      this.jdField_a_of_type_Bkfp.jdField_b_of_type_Boolean = true;
      str = bkbh.c((bkbh)localObject, "0");
      localObject = bkbh.a((bkbh)localObject, "0");
      if ((TextUtils.isEmpty((CharSequence)localObject)) || (!bbev.g(this.jdField_a_of_type_AndroidContentContext))) {
        break label113;
      }
      this.jdField_a_of_type_Bkfp.c = ((String)localObject);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bkfp.a(str);
      if (this.jdField_a_of_type_Bkfj == null) {
        this.jdField_a_of_type_Bkfj = new bkfj("2001");
      }
      return;
      label113:
      this.jdField_a_of_type_Bkfp.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845696);
    }
  }
  
  public bjvo a()
  {
    return this.jdField_a_of_type_Bjvo;
  }
  
  public bkfi a(String paramString)
  {
    return this.jdField_a_of_type_Bjvo.a(paramString);
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Bkfp != null) {
      return this.jdField_a_of_type_Bkfp.f;
    }
    return null;
  }
  
  public List<bkfi> a()
  {
    return a(false);
  }
  
  @NonNull
  public List<bkfi> a(boolean paramBoolean)
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
        Object localObject1 = ((bkbh)tdc.a(39)).a();
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
        localObject1 = ((Collection)localObject1).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localDoodleEmojiItem = (DoodleEmojiItem)((Iterator)localObject1).next();
        if (localDoodleEmojiItem.type == 1)
        {
          localObject3 = new bkfs(localDoodleEmojiItem.pack_id);
          b((bkfs)localObject3, localDoodleEmojiItem);
          if (("1".equals(((bkfs)localObject3).jdField_a_of_type_JavaLangString)) && (!bbev.g(this.jdField_a_of_type_AndroidContentContext))) {
            ((bkfs)localObject3).jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845553);
          }
          this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(localObject3);
          continue;
        }
        if (localDoodleEmojiItem.type != 2) {
          break label398;
        }
      }
      finally {}
      this.jdField_a_of_type_Bkfp.jdField_b_of_type_JavaLangString = localDoodleEmojiItem.name;
      if ((!TextUtils.isEmpty(localDoodleEmojiItem.icon)) && (bbev.g(this.jdField_a_of_type_AndroidContentContext))) {
        this.jdField_a_of_type_Bkfp.c = localDoodleEmojiItem.icon;
      }
      Object localObject4;
      while (localDoodleEmojiItem.mItemList != null)
      {
        this.jdField_a_of_type_Bkfp.jdField_a_of_type_JavaUtilList = localDoodleEmojiItem.mItemList;
        if (localDoodleEmojiItem.mItemList == null) {
          break;
        }
        veg.b("PasterDataManager", "add doodle emoji location item name = " + this.jdField_a_of_type_Bkfp.f);
        localObject3 = localDoodleEmojiItem.mItemList.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (bkfq)((Iterator)localObject3).next();
          ((bkfq)localObject4).g = this.jdField_a_of_type_Bkfp.jdField_b_of_type_JavaLangString;
          ((bkfq)localObject4).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Bkfp.f;
        }
        this.jdField_a_of_type_Bkfp.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845696);
      }
      this.jdField_a_of_type_Bkfp.jdField_a_of_type_Boolean = "1".equals(localDoodleEmojiItem.random_position);
      this.jdField_a_of_type_Bkfp.jdField_a_of_type_Int = localDoodleEmojiItem.hide;
      this.jdField_a_of_type_Bkfp.jdField_b_of_type_Int = localDoodleEmojiItem.mask;
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(this.jdField_a_of_type_Bkfp);
      continue;
      label398:
      if (localDoodleEmojiItem.type == 3)
      {
        if (this.jdField_a_of_type_Bkfj == null) {
          this.jdField_a_of_type_Bkfj = new bkfj(localDoodleEmojiItem.pack_id);
        }
        for (;;)
        {
          this.jdField_a_of_type_Bkfj.jdField_b_of_type_JavaLangString = localDoodleEmojiItem.name;
          this.jdField_a_of_type_Bkfj.jdField_a_of_type_JavaUtilList = localDoodleEmojiItem.mInfoItemList;
          this.jdField_a_of_type_Bkfj.a(localDoodleEmojiItem.config);
          this.jdField_a_of_type_Bkfj.jdField_a_of_type_Int = localDoodleEmojiItem.hide;
          this.jdField_a_of_type_Bkfj.g = "default";
          this.jdField_a_of_type_Bkfj.c = -999;
          this.jdField_a_of_type_Bkfj.h = "--";
          this.jdField_a_of_type_Bkfj.i = "default";
          if (this.jdField_a_of_type_Bkfj.jdField_a_of_type_JavaUtilList == null) {
            break;
          }
          localObject3 = this.jdField_a_of_type_Bkfj.jdField_a_of_type_JavaUtilList.iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (bkfm)((Iterator)localObject3).next();
            ((bkfm)localObject4).m = this.jdField_a_of_type_Bkfj.jdField_b_of_type_JavaLangString;
            if (bkfn.a(((bkfm)localObject4).jdField_a_of_type_Int)) {
              ((bkfm)localObject4).l = this.jdField_a_of_type_Bkfj.f;
            }
            if ((localDoodleEmojiItem.mCityRes != null) && (((bkfm)localObject4).jdField_a_of_type_Int == 7)) {
              a(localDoodleEmojiItem.mCityRes, this.jdField_a_of_type_Bkfj.g, (bkfm)localObject4);
            }
            if (((bkfm)localObject4).jdField_a_of_type_Int == 6)
            {
              ((bkfm)localObject4).c = this.jdField_a_of_type_Bkfj.c;
              ((bkfm)localObject4).j = this.jdField_a_of_type_Bkfj.h;
              ((bkfm)localObject4).k = this.jdField_a_of_type_Bkfj.i;
            }
          }
          this.jdField_a_of_type_Bkfj.jdField_a_of_type_JavaLangString = localDoodleEmojiItem.pack_id;
        }
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(this.jdField_a_of_type_Bkfj);
        this.jdField_a_of_type_Bkfj.jdField_a_of_type_JavaUtilMap = localDoodleEmojiItem.mCityRes;
      }
    }
    veg.b("PasterDataManager", "getDoodleFacePackages, size = " + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
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
  
  public void a(int paramInt, tfb paramtfb, List<TroopBarPOI> paramList)
  {
    veg.b("PasterDataManager", "onPOIListRequestResult." + paramInt);
    if ((paramInt == 0) && (paramtfb != null))
    {
      this.jdField_a_of_type_Tfb = paramtfb;
      if ((paramList != null) && (paramList.size() > 0))
      {
        paramtfb = ((TroopBarPOI)paramList.get(0)).a();
        if (QLog.isColorLevel()) {
          QLog.d("PasterDataManager", 2, "onPOIListRequestResult " + paramtfb);
        }
        String str = ShortVideoUtils.c(QQStoryContext.a().getCurrentAccountUin());
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext()) {
          if (((TroopBarPOI)localIterator.next()).a().equals(str)) {
            paramtfb = str;
          }
        }
      }
    }
    for (;;)
    {
      a(((TroopBarPOI)paramList.get(0)).jdField_b_of_type_JavaLangString, paramtfb, true);
      return;
    }
  }
  
  public void a(String paramString)
  {
    a(null, paramString, false);
  }
  
  public void a(teu paramteu)
  {
    this.jdField_a_of_type_Tdq = ((tdq)((tcd)tdc.a(20)).a(0));
    Object localObject = this.jdField_a_of_type_Tdq.a();
    if (localObject != null)
    {
      veg.b("PasterDataManager", "get weather from cache.");
      a((tdt)localObject);
      return;
    }
    veg.b("PasterDataManager", "get weather from net.");
    localObject = paramteu;
    if (paramteu == null) {
      localObject = tev.a();
    }
    this.jdField_a_of_type_Tdq.a(this);
    this.jdField_a_of_type_Tdq.b((teu)localObject);
  }
  
  public void a(boolean paramBoolean, Activity paramActivity)
  {
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Bkfj != null) && (!"default".equals(this.jdField_a_of_type_Bkfj.g)) && (!"--".equals(this.jdField_a_of_type_Bkfj.h))) {
      return;
    }
    new avtj(paramActivity, new bjew(this, paramBoolean)).a();
  }
  
  public void a(boolean paramBoolean, tdt paramtdt)
  {
    if (paramBoolean) {
      a(paramtdt);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Bjey != null)
    {
      ste.a().unRegisterSubscriber(this.jdField_a_of_type_Bjey);
      this.jdField_a_of_type_Bjey = null;
    }
    if (this.jdField_a_of_type_Tdq != null) {
      this.jdField_a_of_type_Tdq.b(this);
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.getContext();
    this.jdField_a_of_type_Bjvo = new bjvo();
    e();
    this.jdField_a_of_type_Bjey = new bjey(this);
    ste.a().registerSubscriber(this.jdField_a_of_type_Bjey);
    if (QLog.isDevelopLevel()) {
      QLog.d("PasterDataManager", 4, "initPasterConfig");
    }
  }
  
  public void d()
  {
    this.jdField_b_of_type_Boolean = false;
  }
  
  public boolean isValidate()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjeu
 * JD-Core Version:    0.7.0.1
 */