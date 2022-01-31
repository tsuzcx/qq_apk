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

public class blqw
  extends blnf
  implements IEventReceiver, uqr<usi>, utp
{
  public static AtomicBoolean a;
  private Context jdField_a_of_type_AndroidContentContext;
  protected Handler a;
  private blra jdField_a_of_type_Blra;
  protected bmhp a;
  public bmnt a;
  protected bmrk a;
  protected bmrq a;
  protected Runnable a;
  public CopyOnWriteArrayList<bmrj> a;
  private usf jdField_a_of_type_Usf;
  public utq a;
  public boolean a;
  private boolean b;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  public blqw()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_Utq = null;
    this.jdField_a_of_type_JavaLangRunnable = new PasterDataManager.1(this);
    this.jdField_a_of_type_Bmnt = new blqx(this);
  }
  
  private void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((paramString1 != null) && (this.jdField_a_of_type_Bmrk != null) && (!paramString1.equals(this.jdField_a_of_type_Bmrk.g))) {
      this.jdField_a_of_type_Bmrk.g = paramString1;
    }
    if ((paramString2 != null) && (this.jdField_a_of_type_Bmrq != null) && (!paramString2.equals(this.jdField_a_of_type_Bmrq.f))) {}
    for (int i = 1;; i = 0)
    {
      if ((this.jdField_a_of_type_Bmrq != null) && (i != 0))
      {
        this.jdField_a_of_type_Bmrq.f = paramString2;
        paramString1 = this.jdField_a_of_type_Bmrq.jdField_a_of_type_JavaUtilList.iterator();
        while (paramString1.hasNext()) {
          ((bmrr)paramString1.next()).jdField_b_of_type_JavaLangString = paramString2;
        }
        if (paramBoolean) {
          this.jdField_a_of_type_Bmhp.a(this.jdField_a_of_type_Bmrq);
        }
      }
      if (this.jdField_a_of_type_Bmrk != null)
      {
        if (i != 0)
        {
          this.jdField_a_of_type_Bmrk.f = paramString2;
          paramString1 = this.jdField_a_of_type_Bmrk.jdField_a_of_type_JavaUtilList.iterator();
          while (paramString1.hasNext())
          {
            bmrn localbmrn = (bmrn)paramString1.next();
            if (localbmrn.jdField_a_of_type_Boolean) {
              localbmrn.l = paramString2;
            }
          }
        }
        paramString1 = this.jdField_a_of_type_Bmrk.jdField_a_of_type_JavaUtilList.iterator();
        while (paramString1.hasNext())
        {
          paramString2 = (bmrn)paramString1.next();
          if ((paramString2.jdField_a_of_type_Int == 7) && (!this.jdField_a_of_type_Bmrk.g.equals(paramString2.i)) && (this.jdField_a_of_type_Bmrk.jdField_a_of_type_JavaUtilMap != null)) {
            a(this.jdField_a_of_type_Bmrk.jdField_a_of_type_JavaUtilMap, this.jdField_a_of_type_Bmrk.g, paramString2);
          }
        }
        if (paramBoolean) {
          this.jdField_a_of_type_Bmhp.a(this.jdField_a_of_type_Bmrk);
        }
      }
      return;
    }
  }
  
  private void a(Map<String, Map<String, bmrl>> paramMap, String paramString, bmrn parambmrn)
  {
    if (parambmrn.a() != null) {
      parambmrn.a().c();
    }
    Map localMap = (Map)paramMap.get(parambmrn.h);
    if (localMap != null)
    {
      paramMap = (bmrl)localMap.get(paramString);
      if (paramMap != null) {
        break label94;
      }
      paramMap = (bmrl)localMap.get("default");
    }
    label94:
    for (;;)
    {
      if (paramMap != null)
      {
        parambmrn.g = paramMap.jdField_a_of_type_JavaLangString;
        parambmrn.e = paramMap.jdField_b_of_type_JavaLangString;
        parambmrn.f = paramMap.c;
      }
      return;
    }
  }
  
  private void a(usi paramusi)
  {
    if (paramusi != null)
    {
      this.jdField_a_of_type_Bmrk.c = paramusi.jdField_a_of_type_Int;
      if (paramusi.jdField_a_of_type_JavaLangString != null)
      {
        paramusi = paramusi.jdField_a_of_type_JavaLangString.split("\\|");
        if ((paramusi != null) && (paramusi.length == 2))
        {
          this.jdField_a_of_type_Bmrk.h = paramusi[0];
          this.jdField_a_of_type_Bmrk.i = paramusi[1];
        }
        paramusi = this.jdField_a_of_type_Bmrk.jdField_a_of_type_JavaUtilList.iterator();
        while (paramusi.hasNext())
        {
          bmrn localbmrn = (bmrn)paramusi.next();
          if (localbmrn.jdField_a_of_type_Int == 6)
          {
            localbmrn.j = this.jdField_a_of_type_Bmrk.h;
            localbmrn.k = this.jdField_a_of_type_Bmrk.i;
            localbmrn.c = this.jdField_a_of_type_Bmrk.c;
          }
        }
      }
    }
  }
  
  private void a(utj paramutj, boolean paramBoolean)
  {
    wsv.b("PasterDataManager", "requestPoiList");
    utk localutk = (utk)urr.a(9);
    utj localutj = paramutj;
    if (paramutj == null) {
      localutj = utk.a();
    }
    if (paramBoolean)
    {
      localutk.a(localutj, null, this);
      return;
    }
    localutk.a(localutj, this.jdField_a_of_type_Utq, this);
  }
  
  private void a(boolean paramBoolean)
  {
    a(null, paramBoolean);
  }
  
  private static void b(bmrt parambmrt, DoodleEmojiItem paramDoodleEmojiItem)
  {
    parambmrt.jdField_b_of_type_JavaLangString = paramDoodleEmojiItem.name;
    parambmrt.c = paramDoodleEmojiItem.icon;
    parambmrt.d = paramDoodleEmojiItem.download_icon;
    parambmrt.g = paramDoodleEmojiItem.getLocalEmojiFolderPath();
    parambmrt.e = paramDoodleEmojiItem.download_wording;
    parambmrt.jdField_a_of_type_Boolean = "1".equals(paramDoodleEmojiItem.random_position);
    parambmrt.a(paramDoodleEmojiItem.config);
    parambmrt.jdField_a_of_type_Int = paramDoodleEmojiItem.hide;
    parambmrt.jdField_b_of_type_Int = paramDoodleEmojiItem.mask;
  }
  
  private void e()
  {
    Object localObject = (bmni)urr.a(39);
    ((bmni)localObject).c();
    String str;
    if (this.jdField_a_of_type_Bmrq == null)
    {
      this.jdField_a_of_type_Bmrq = new bmrq("0");
      this.jdField_a_of_type_Bmrq.jdField_b_of_type_Boolean = true;
      str = bmni.c((bmni)localObject, "0");
      localObject = bmni.a((bmni)localObject, "0");
      if ((TextUtils.isEmpty((CharSequence)localObject)) || (!bdee.g(this.jdField_a_of_type_AndroidContentContext))) {
        break label113;
      }
      this.jdField_a_of_type_Bmrq.c = ((String)localObject);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bmrq.a(str);
      if (this.jdField_a_of_type_Bmrk == null) {
        this.jdField_a_of_type_Bmrk = new bmrk("2001");
      }
      return;
      label113:
      this.jdField_a_of_type_Bmrq.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846081);
    }
  }
  
  public bmhp a()
  {
    return this.jdField_a_of_type_Bmhp;
  }
  
  public bmrj a(String paramString)
  {
    return this.jdField_a_of_type_Bmhp.a(paramString);
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Bmrq != null) {
      return this.jdField_a_of_type_Bmrq.f;
    }
    return null;
  }
  
  public List<bmrj> a()
  {
    return a(false);
  }
  
  @NonNull
  public List<bmrj> a(boolean paramBoolean)
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
        Object localObject1 = ((bmni)urr.a(39)).a();
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
        localObject1 = ((Collection)localObject1).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localDoodleEmojiItem = (DoodleEmojiItem)((Iterator)localObject1).next();
        if (localDoodleEmojiItem.type == 1)
        {
          localObject3 = new bmrt(localDoodleEmojiItem.pack_id);
          b((bmrt)localObject3, localDoodleEmojiItem);
          if (("1".equals(((bmrt)localObject3).jdField_a_of_type_JavaLangString)) && (!bdee.g(this.jdField_a_of_type_AndroidContentContext))) {
            ((bmrt)localObject3).jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845938);
          }
          this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(localObject3);
          continue;
        }
        if (localDoodleEmojiItem.type != 2) {
          break label398;
        }
      }
      finally {}
      this.jdField_a_of_type_Bmrq.jdField_b_of_type_JavaLangString = localDoodleEmojiItem.name;
      if ((!TextUtils.isEmpty(localDoodleEmojiItem.icon)) && (bdee.g(this.jdField_a_of_type_AndroidContentContext))) {
        this.jdField_a_of_type_Bmrq.c = localDoodleEmojiItem.icon;
      }
      Object localObject4;
      while (localDoodleEmojiItem.mItemList != null)
      {
        this.jdField_a_of_type_Bmrq.jdField_a_of_type_JavaUtilList = localDoodleEmojiItem.mItemList;
        if (localDoodleEmojiItem.mItemList == null) {
          break;
        }
        wsv.b("PasterDataManager", "add doodle emoji location item name = " + this.jdField_a_of_type_Bmrq.f);
        localObject3 = localDoodleEmojiItem.mItemList.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (bmrr)((Iterator)localObject3).next();
          ((bmrr)localObject4).g = this.jdField_a_of_type_Bmrq.jdField_b_of_type_JavaLangString;
          ((bmrr)localObject4).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Bmrq.f;
        }
        this.jdField_a_of_type_Bmrq.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846081);
      }
      this.jdField_a_of_type_Bmrq.jdField_a_of_type_Boolean = "1".equals(localDoodleEmojiItem.random_position);
      this.jdField_a_of_type_Bmrq.jdField_a_of_type_Int = localDoodleEmojiItem.hide;
      this.jdField_a_of_type_Bmrq.jdField_b_of_type_Int = localDoodleEmojiItem.mask;
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(this.jdField_a_of_type_Bmrq);
      continue;
      label398:
      if (localDoodleEmojiItem.type == 3)
      {
        if (this.jdField_a_of_type_Bmrk == null) {
          this.jdField_a_of_type_Bmrk = new bmrk(localDoodleEmojiItem.pack_id);
        }
        for (;;)
        {
          this.jdField_a_of_type_Bmrk.jdField_b_of_type_JavaLangString = localDoodleEmojiItem.name;
          this.jdField_a_of_type_Bmrk.jdField_a_of_type_JavaUtilList = localDoodleEmojiItem.mInfoItemList;
          this.jdField_a_of_type_Bmrk.a(localDoodleEmojiItem.config);
          this.jdField_a_of_type_Bmrk.jdField_a_of_type_Int = localDoodleEmojiItem.hide;
          this.jdField_a_of_type_Bmrk.g = "default";
          this.jdField_a_of_type_Bmrk.c = -999;
          this.jdField_a_of_type_Bmrk.h = "--";
          this.jdField_a_of_type_Bmrk.i = "default";
          if (this.jdField_a_of_type_Bmrk.jdField_a_of_type_JavaUtilList == null) {
            break;
          }
          localObject3 = this.jdField_a_of_type_Bmrk.jdField_a_of_type_JavaUtilList.iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (bmrn)((Iterator)localObject3).next();
            ((bmrn)localObject4).m = this.jdField_a_of_type_Bmrk.jdField_b_of_type_JavaLangString;
            if (bmro.a(((bmrn)localObject4).jdField_a_of_type_Int)) {
              ((bmrn)localObject4).l = this.jdField_a_of_type_Bmrk.f;
            }
            if ((localDoodleEmojiItem.mCityRes != null) && (((bmrn)localObject4).jdField_a_of_type_Int == 7)) {
              a(localDoodleEmojiItem.mCityRes, this.jdField_a_of_type_Bmrk.g, (bmrn)localObject4);
            }
            if (((bmrn)localObject4).jdField_a_of_type_Int == 6)
            {
              ((bmrn)localObject4).c = this.jdField_a_of_type_Bmrk.c;
              ((bmrn)localObject4).j = this.jdField_a_of_type_Bmrk.h;
              ((bmrn)localObject4).k = this.jdField_a_of_type_Bmrk.i;
            }
          }
          this.jdField_a_of_type_Bmrk.jdField_a_of_type_JavaLangString = localDoodleEmojiItem.pack_id;
        }
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(this.jdField_a_of_type_Bmrk);
        this.jdField_a_of_type_Bmrk.jdField_a_of_type_JavaUtilMap = localDoodleEmojiItem.mCityRes;
      }
    }
    wsv.b("PasterDataManager", "getDoodleFacePackages, size = " + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
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
  
  public void a(int paramInt, utq paramutq, List<TroopBarPOI> paramList)
  {
    wsv.b("PasterDataManager", "onPOIListRequestResult." + paramInt);
    if ((paramInt == 0) && (paramutq != null))
    {
      this.jdField_a_of_type_Utq = paramutq;
      if ((paramList != null) && (paramList.size() > 0))
      {
        paramutq = ((TroopBarPOI)paramList.get(0)).a();
        if (QLog.isColorLevel()) {
          QLog.d("PasterDataManager", 2, "onPOIListRequestResult " + paramutq);
        }
        String str = ShortVideoUtils.c(QQStoryContext.a().getCurrentAccountUin());
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext()) {
          if (((TroopBarPOI)localIterator.next()).a().equals(str)) {
            paramutq = str;
          }
        }
      }
    }
    for (;;)
    {
      a(((TroopBarPOI)paramList.get(0)).jdField_b_of_type_JavaLangString, paramutq, true);
      return;
    }
  }
  
  public void a(String paramString)
  {
    a(null, paramString, false);
  }
  
  public void a(utj paramutj)
  {
    this.jdField_a_of_type_Usf = ((usf)((uqs)urr.a(20)).a(0));
    Object localObject = this.jdField_a_of_type_Usf.a();
    if (localObject != null)
    {
      wsv.b("PasterDataManager", "get weather from cache.");
      a((usi)localObject);
      return;
    }
    wsv.b("PasterDataManager", "get weather from net.");
    localObject = paramutj;
    if (paramutj == null) {
      localObject = utk.a();
    }
    this.jdField_a_of_type_Usf.a(this);
    this.jdField_a_of_type_Usf.b((utj)localObject);
  }
  
  public void a(boolean paramBoolean, Activity paramActivity)
  {
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Bmrk != null) && (!"default".equals(this.jdField_a_of_type_Bmrk.g)) && (!"--".equals(this.jdField_a_of_type_Bmrk.h))) {
      return;
    }
    new axlk(paramActivity, new blqy(this, paramBoolean)).a();
  }
  
  public void a(boolean paramBoolean, usi paramusi)
  {
    if (paramBoolean) {
      a(paramusi);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Blra != null)
    {
      uht.a().unRegisterSubscriber(this.jdField_a_of_type_Blra);
      this.jdField_a_of_type_Blra = null;
    }
    if (this.jdField_a_of_type_Usf != null) {
      this.jdField_a_of_type_Usf.b(this);
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.getContext();
    this.jdField_a_of_type_Bmhp = new bmhp();
    e();
    this.jdField_a_of_type_Blra = new blra(this);
    uht.a().registerSubscriber(this.jdField_a_of_type_Blra);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blqw
 * JD-Core Version:    0.7.0.1
 */