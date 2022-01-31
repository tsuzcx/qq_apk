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

public class bjfl
  extends bjbv
  implements IEventReceiver, tbz<tdq>, tex
{
  public static AtomicBoolean a;
  private Context jdField_a_of_type_AndroidContentContext;
  protected Handler a;
  private bjfp jdField_a_of_type_Bjfp;
  protected bjwf a;
  public bkcj a;
  protected bkga a;
  protected bkgg a;
  protected Runnable a;
  public CopyOnWriteArrayList<bkfz> a;
  private tdn jdField_a_of_type_Tdn;
  public tey a;
  public boolean a;
  private boolean b;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  public bjfl()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_Tey = null;
    this.jdField_a_of_type_JavaLangRunnable = new PasterDataManager.1(this);
    this.jdField_a_of_type_Bkcj = new bjfm(this);
  }
  
  private void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((paramString1 != null) && (this.jdField_a_of_type_Bkga != null) && (!paramString1.equals(this.jdField_a_of_type_Bkga.g))) {
      this.jdField_a_of_type_Bkga.g = paramString1;
    }
    if ((paramString2 != null) && (this.jdField_a_of_type_Bkgg != null) && (!paramString2.equals(this.jdField_a_of_type_Bkgg.f))) {}
    for (int i = 1;; i = 0)
    {
      if ((this.jdField_a_of_type_Bkgg != null) && (i != 0))
      {
        this.jdField_a_of_type_Bkgg.f = paramString2;
        paramString1 = this.jdField_a_of_type_Bkgg.jdField_a_of_type_JavaUtilList.iterator();
        while (paramString1.hasNext()) {
          ((bkgh)paramString1.next()).jdField_b_of_type_JavaLangString = paramString2;
        }
        if (paramBoolean) {
          this.jdField_a_of_type_Bjwf.a(this.jdField_a_of_type_Bkgg);
        }
      }
      if (this.jdField_a_of_type_Bkga != null)
      {
        if (i != 0)
        {
          this.jdField_a_of_type_Bkga.f = paramString2;
          paramString1 = this.jdField_a_of_type_Bkga.jdField_a_of_type_JavaUtilList.iterator();
          while (paramString1.hasNext())
          {
            bkgd localbkgd = (bkgd)paramString1.next();
            if (localbkgd.jdField_a_of_type_Boolean) {
              localbkgd.l = paramString2;
            }
          }
        }
        paramString1 = this.jdField_a_of_type_Bkga.jdField_a_of_type_JavaUtilList.iterator();
        while (paramString1.hasNext())
        {
          paramString2 = (bkgd)paramString1.next();
          if ((paramString2.jdField_a_of_type_Int == 7) && (!this.jdField_a_of_type_Bkga.g.equals(paramString2.i)) && (this.jdField_a_of_type_Bkga.jdField_a_of_type_JavaUtilMap != null)) {
            a(this.jdField_a_of_type_Bkga.jdField_a_of_type_JavaUtilMap, this.jdField_a_of_type_Bkga.g, paramString2);
          }
        }
        if (paramBoolean) {
          this.jdField_a_of_type_Bjwf.a(this.jdField_a_of_type_Bkga);
        }
      }
      return;
    }
  }
  
  private void a(Map<String, Map<String, bkgb>> paramMap, String paramString, bkgd parambkgd)
  {
    if (parambkgd.a() != null) {
      parambkgd.a().c();
    }
    Map localMap = (Map)paramMap.get(parambkgd.h);
    if (localMap != null)
    {
      paramMap = (bkgb)localMap.get(paramString);
      if (paramMap != null) {
        break label94;
      }
      paramMap = (bkgb)localMap.get("default");
    }
    label94:
    for (;;)
    {
      if (paramMap != null)
      {
        parambkgd.g = paramMap.jdField_a_of_type_JavaLangString;
        parambkgd.e = paramMap.jdField_b_of_type_JavaLangString;
        parambkgd.f = paramMap.c;
      }
      return;
    }
  }
  
  private void a(tdq paramtdq)
  {
    if (paramtdq != null)
    {
      this.jdField_a_of_type_Bkga.c = paramtdq.jdField_a_of_type_Int;
      if (paramtdq.jdField_a_of_type_JavaLangString != null)
      {
        paramtdq = paramtdq.jdField_a_of_type_JavaLangString.split("\\|");
        if ((paramtdq != null) && (paramtdq.length == 2))
        {
          this.jdField_a_of_type_Bkga.h = paramtdq[0];
          this.jdField_a_of_type_Bkga.i = paramtdq[1];
        }
        paramtdq = this.jdField_a_of_type_Bkga.jdField_a_of_type_JavaUtilList.iterator();
        while (paramtdq.hasNext())
        {
          bkgd localbkgd = (bkgd)paramtdq.next();
          if (localbkgd.jdField_a_of_type_Int == 6)
          {
            localbkgd.j = this.jdField_a_of_type_Bkga.h;
            localbkgd.k = this.jdField_a_of_type_Bkga.i;
            localbkgd.c = this.jdField_a_of_type_Bkga.c;
          }
        }
      }
    }
  }
  
  private void a(ter paramter, boolean paramBoolean)
  {
    ved.b("PasterDataManager", "requestPoiList");
    tes localtes = (tes)tcz.a(9);
    ter localter = paramter;
    if (paramter == null) {
      localter = tes.a();
    }
    if (paramBoolean)
    {
      localtes.a(localter, null, this);
      return;
    }
    localtes.a(localter, this.jdField_a_of_type_Tey, this);
  }
  
  private void a(boolean paramBoolean)
  {
    a(null, paramBoolean);
  }
  
  private static void b(bkgj parambkgj, DoodleEmojiItem paramDoodleEmojiItem)
  {
    parambkgj.jdField_b_of_type_JavaLangString = paramDoodleEmojiItem.name;
    parambkgj.c = paramDoodleEmojiItem.icon;
    parambkgj.d = paramDoodleEmojiItem.download_icon;
    parambkgj.g = paramDoodleEmojiItem.getLocalEmojiFolderPath();
    parambkgj.e = paramDoodleEmojiItem.download_wording;
    parambkgj.jdField_a_of_type_Boolean = "1".equals(paramDoodleEmojiItem.random_position);
    parambkgj.a(paramDoodleEmojiItem.config);
    parambkgj.jdField_a_of_type_Int = paramDoodleEmojiItem.hide;
    parambkgj.jdField_b_of_type_Int = paramDoodleEmojiItem.mask;
  }
  
  private void e()
  {
    Object localObject = (bkby)tcz.a(39);
    ((bkby)localObject).c();
    String str;
    if (this.jdField_a_of_type_Bkgg == null)
    {
      this.jdField_a_of_type_Bkgg = new bkgg("0");
      this.jdField_a_of_type_Bkgg.jdField_b_of_type_Boolean = true;
      str = bkby.c((bkby)localObject, "0");
      localObject = bkby.a((bkby)localObject, "0");
      if ((TextUtils.isEmpty((CharSequence)localObject)) || (!bbfj.g(this.jdField_a_of_type_AndroidContentContext))) {
        break label113;
      }
      this.jdField_a_of_type_Bkgg.c = ((String)localObject);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bkgg.a(str);
      if (this.jdField_a_of_type_Bkga == null) {
        this.jdField_a_of_type_Bkga = new bkga("2001");
      }
      return;
      label113:
      this.jdField_a_of_type_Bkgg.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845702);
    }
  }
  
  public bjwf a()
  {
    return this.jdField_a_of_type_Bjwf;
  }
  
  public bkfz a(String paramString)
  {
    return this.jdField_a_of_type_Bjwf.a(paramString);
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Bkgg != null) {
      return this.jdField_a_of_type_Bkgg.f;
    }
    return null;
  }
  
  public List<bkfz> a()
  {
    return a(false);
  }
  
  @NonNull
  public List<bkfz> a(boolean paramBoolean)
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
        Object localObject1 = ((bkby)tcz.a(39)).a();
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
        localObject1 = ((Collection)localObject1).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localDoodleEmojiItem = (DoodleEmojiItem)((Iterator)localObject1).next();
        if (localDoodleEmojiItem.type == 1)
        {
          localObject3 = new bkgj(localDoodleEmojiItem.pack_id);
          b((bkgj)localObject3, localDoodleEmojiItem);
          if (("1".equals(((bkgj)localObject3).jdField_a_of_type_JavaLangString)) && (!bbfj.g(this.jdField_a_of_type_AndroidContentContext))) {
            ((bkgj)localObject3).jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845559);
          }
          this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(localObject3);
          continue;
        }
        if (localDoodleEmojiItem.type != 2) {
          break label398;
        }
      }
      finally {}
      this.jdField_a_of_type_Bkgg.jdField_b_of_type_JavaLangString = localDoodleEmojiItem.name;
      if ((!TextUtils.isEmpty(localDoodleEmojiItem.icon)) && (bbfj.g(this.jdField_a_of_type_AndroidContentContext))) {
        this.jdField_a_of_type_Bkgg.c = localDoodleEmojiItem.icon;
      }
      Object localObject4;
      while (localDoodleEmojiItem.mItemList != null)
      {
        this.jdField_a_of_type_Bkgg.jdField_a_of_type_JavaUtilList = localDoodleEmojiItem.mItemList;
        if (localDoodleEmojiItem.mItemList == null) {
          break;
        }
        ved.b("PasterDataManager", "add doodle emoji location item name = " + this.jdField_a_of_type_Bkgg.f);
        localObject3 = localDoodleEmojiItem.mItemList.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (bkgh)((Iterator)localObject3).next();
          ((bkgh)localObject4).g = this.jdField_a_of_type_Bkgg.jdField_b_of_type_JavaLangString;
          ((bkgh)localObject4).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Bkgg.f;
        }
        this.jdField_a_of_type_Bkgg.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845702);
      }
      this.jdField_a_of_type_Bkgg.jdField_a_of_type_Boolean = "1".equals(localDoodleEmojiItem.random_position);
      this.jdField_a_of_type_Bkgg.jdField_a_of_type_Int = localDoodleEmojiItem.hide;
      this.jdField_a_of_type_Bkgg.jdField_b_of_type_Int = localDoodleEmojiItem.mask;
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(this.jdField_a_of_type_Bkgg);
      continue;
      label398:
      if (localDoodleEmojiItem.type == 3)
      {
        if (this.jdField_a_of_type_Bkga == null) {
          this.jdField_a_of_type_Bkga = new bkga(localDoodleEmojiItem.pack_id);
        }
        for (;;)
        {
          this.jdField_a_of_type_Bkga.jdField_b_of_type_JavaLangString = localDoodleEmojiItem.name;
          this.jdField_a_of_type_Bkga.jdField_a_of_type_JavaUtilList = localDoodleEmojiItem.mInfoItemList;
          this.jdField_a_of_type_Bkga.a(localDoodleEmojiItem.config);
          this.jdField_a_of_type_Bkga.jdField_a_of_type_Int = localDoodleEmojiItem.hide;
          this.jdField_a_of_type_Bkga.g = "default";
          this.jdField_a_of_type_Bkga.c = -999;
          this.jdField_a_of_type_Bkga.h = "--";
          this.jdField_a_of_type_Bkga.i = "default";
          if (this.jdField_a_of_type_Bkga.jdField_a_of_type_JavaUtilList == null) {
            break;
          }
          localObject3 = this.jdField_a_of_type_Bkga.jdField_a_of_type_JavaUtilList.iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (bkgd)((Iterator)localObject3).next();
            ((bkgd)localObject4).m = this.jdField_a_of_type_Bkga.jdField_b_of_type_JavaLangString;
            if (bkge.a(((bkgd)localObject4).jdField_a_of_type_Int)) {
              ((bkgd)localObject4).l = this.jdField_a_of_type_Bkga.f;
            }
            if ((localDoodleEmojiItem.mCityRes != null) && (((bkgd)localObject4).jdField_a_of_type_Int == 7)) {
              a(localDoodleEmojiItem.mCityRes, this.jdField_a_of_type_Bkga.g, (bkgd)localObject4);
            }
            if (((bkgd)localObject4).jdField_a_of_type_Int == 6)
            {
              ((bkgd)localObject4).c = this.jdField_a_of_type_Bkga.c;
              ((bkgd)localObject4).j = this.jdField_a_of_type_Bkga.h;
              ((bkgd)localObject4).k = this.jdField_a_of_type_Bkga.i;
            }
          }
          this.jdField_a_of_type_Bkga.jdField_a_of_type_JavaLangString = localDoodleEmojiItem.pack_id;
        }
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(this.jdField_a_of_type_Bkga);
        this.jdField_a_of_type_Bkga.jdField_a_of_type_JavaUtilMap = localDoodleEmojiItem.mCityRes;
      }
    }
    ved.b("PasterDataManager", "getDoodleFacePackages, size = " + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
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
  
  public void a(int paramInt, tey paramtey, List<TroopBarPOI> paramList)
  {
    ved.b("PasterDataManager", "onPOIListRequestResult." + paramInt);
    if ((paramInt == 0) && (paramtey != null))
    {
      this.jdField_a_of_type_Tey = paramtey;
      if ((paramList != null) && (paramList.size() > 0))
      {
        paramtey = ((TroopBarPOI)paramList.get(0)).a();
        if (QLog.isColorLevel()) {
          QLog.d("PasterDataManager", 2, "onPOIListRequestResult " + paramtey);
        }
        String str = ShortVideoUtils.c(QQStoryContext.a().getCurrentAccountUin());
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext()) {
          if (((TroopBarPOI)localIterator.next()).a().equals(str)) {
            paramtey = str;
          }
        }
      }
    }
    for (;;)
    {
      a(((TroopBarPOI)paramList.get(0)).jdField_b_of_type_JavaLangString, paramtey, true);
      return;
    }
  }
  
  public void a(String paramString)
  {
    a(null, paramString, false);
  }
  
  public void a(ter paramter)
  {
    this.jdField_a_of_type_Tdn = ((tdn)((tca)tcz.a(20)).a(0));
    Object localObject = this.jdField_a_of_type_Tdn.a();
    if (localObject != null)
    {
      ved.b("PasterDataManager", "get weather from cache.");
      a((tdq)localObject);
      return;
    }
    ved.b("PasterDataManager", "get weather from net.");
    localObject = paramter;
    if (paramter == null) {
      localObject = tes.a();
    }
    this.jdField_a_of_type_Tdn.a(this);
    this.jdField_a_of_type_Tdn.b((ter)localObject);
  }
  
  public void a(boolean paramBoolean, Activity paramActivity)
  {
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Bkga != null) && (!"default".equals(this.jdField_a_of_type_Bkga.g)) && (!"--".equals(this.jdField_a_of_type_Bkga.h))) {
      return;
    }
    new avtl(paramActivity, new bjfn(this, paramBoolean)).a();
  }
  
  public void a(boolean paramBoolean, tdq paramtdq)
  {
    if (paramBoolean) {
      a(paramtdq);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Bjfp != null)
    {
      stb.a().unRegisterSubscriber(this.jdField_a_of_type_Bjfp);
      this.jdField_a_of_type_Bjfp = null;
    }
    if (this.jdField_a_of_type_Tdn != null) {
      this.jdField_a_of_type_Tdn.b(this);
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.getContext();
    this.jdField_a_of_type_Bjwf = new bjwf();
    e();
    this.jdField_a_of_type_Bjfp = new bjfp(this);
    stb.a().registerSubscriber(this.jdField_a_of_type_Bjfp);
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
 * Qualified Name:     bjfl
 * JD-Core Version:    0.7.0.1
 */