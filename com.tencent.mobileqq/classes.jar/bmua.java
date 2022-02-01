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
import com.tencent.mobileqq.utils.NetworkUtil;
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

public class bmua
  extends bmrl
  implements IEventReceiver, vtx<vvo>, vwv
{
  public static AtomicBoolean a;
  private Context jdField_a_of_type_AndroidContentContext;
  protected Handler a;
  private bmue jdField_a_of_type_Bmue;
  protected bndx a;
  public bnhs a;
  protected bnlf a;
  protected bnlk a;
  protected Runnable a;
  public CopyOnWriteArrayList<bnle> a;
  private vvl jdField_a_of_type_Vvl;
  public vww a;
  public boolean a;
  private boolean b;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  public bmua()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_Vww = null;
    this.jdField_a_of_type_JavaLangRunnable = new PasterDataManager.1(this);
    this.jdField_a_of_type_Bnhs = new bmub(this);
  }
  
  private void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((paramString1 != null) && (this.jdField_a_of_type_Bnlf != null) && (!paramString1.equals(this.jdField_a_of_type_Bnlf.g))) {
      this.jdField_a_of_type_Bnlf.g = paramString1;
    }
    if ((paramString2 != null) && (this.jdField_a_of_type_Bnlk != null) && (!paramString2.equals(this.jdField_a_of_type_Bnlk.f))) {}
    for (int i = 1;; i = 0)
    {
      if ((this.jdField_a_of_type_Bnlk != null) && (i != 0))
      {
        this.jdField_a_of_type_Bnlk.f = paramString2;
        paramString1 = this.jdField_a_of_type_Bnlk.jdField_a_of_type_JavaUtilList.iterator();
        while (paramString1.hasNext()) {
          ((bnll)paramString1.next()).jdField_b_of_type_JavaLangString = paramString2;
        }
        if (paramBoolean) {
          this.jdField_a_of_type_Bndx.a(this.jdField_a_of_type_Bnlk);
        }
      }
      if (this.jdField_a_of_type_Bnlf != null)
      {
        if (i != 0)
        {
          this.jdField_a_of_type_Bnlf.f = paramString2;
          paramString1 = this.jdField_a_of_type_Bnlf.jdField_a_of_type_JavaUtilList.iterator();
          while (paramString1.hasNext())
          {
            bnli localbnli = (bnli)paramString1.next();
            if (localbnli.jdField_a_of_type_Boolean) {
              localbnli.l = paramString2;
            }
          }
        }
        paramString1 = this.jdField_a_of_type_Bnlf.jdField_a_of_type_JavaUtilList.iterator();
        while (paramString1.hasNext())
        {
          paramString2 = (bnli)paramString1.next();
          if ((paramString2.jdField_a_of_type_Int == 7) && (!this.jdField_a_of_type_Bnlf.g.equals(paramString2.i)) && (this.jdField_a_of_type_Bnlf.jdField_a_of_type_JavaUtilMap != null)) {
            a(this.jdField_a_of_type_Bnlf.jdField_a_of_type_JavaUtilMap, this.jdField_a_of_type_Bnlf.g, paramString2);
          }
        }
        if (paramBoolean) {
          this.jdField_a_of_type_Bndx.a(this.jdField_a_of_type_Bnlf);
        }
      }
      return;
    }
  }
  
  private void a(Map<String, Map<String, bnlg>> paramMap, String paramString, bnli parambnli)
  {
    if (parambnli.a() != null) {
      parambnli.a().c();
    }
    Map localMap = (Map)paramMap.get(parambnli.h);
    if (localMap != null)
    {
      paramMap = (bnlg)localMap.get(paramString);
      if (paramMap != null) {
        break label94;
      }
      paramMap = (bnlg)localMap.get("default");
    }
    label94:
    for (;;)
    {
      if (paramMap != null)
      {
        parambnli.g = paramMap.jdField_a_of_type_JavaLangString;
        parambnli.e = paramMap.jdField_b_of_type_JavaLangString;
        parambnli.f = paramMap.c;
      }
      return;
    }
  }
  
  private void a(vvo paramvvo)
  {
    if (paramvvo != null)
    {
      this.jdField_a_of_type_Bnlf.c = paramvvo.jdField_a_of_type_Int;
      if (paramvvo.jdField_a_of_type_JavaLangString != null)
      {
        paramvvo = paramvvo.jdField_a_of_type_JavaLangString.split("\\|");
        if ((paramvvo != null) && (paramvvo.length == 2))
        {
          this.jdField_a_of_type_Bnlf.h = paramvvo[0];
          this.jdField_a_of_type_Bnlf.i = paramvvo[1];
        }
        paramvvo = this.jdField_a_of_type_Bnlf.jdField_a_of_type_JavaUtilList.iterator();
        while (paramvvo.hasNext())
        {
          bnli localbnli = (bnli)paramvvo.next();
          if (localbnli.jdField_a_of_type_Int == 6)
          {
            localbnli.j = this.jdField_a_of_type_Bnlf.h;
            localbnli.k = this.jdField_a_of_type_Bnlf.i;
            localbnli.c = this.jdField_a_of_type_Bnlf.c;
          }
        }
      }
    }
  }
  
  private void a(vwp paramvwp, boolean paramBoolean)
  {
    xvv.b("PasterDataManager", "requestPoiList");
    vwq localvwq = (vwq)vux.a(9);
    vwp localvwp = paramvwp;
    if (paramvwp == null) {
      localvwp = vwq.a();
    }
    if (paramBoolean)
    {
      localvwq.a(localvwp, null, this);
      return;
    }
    localvwq.a(localvwp, this.jdField_a_of_type_Vww, this);
  }
  
  private void a(boolean paramBoolean)
  {
    a(null, paramBoolean);
  }
  
  private void b()
  {
    Object localObject = (bnhh)vux.a(39);
    ((bnhh)localObject).c();
    String str;
    if (this.jdField_a_of_type_Bnlk == null)
    {
      this.jdField_a_of_type_Bnlk = new bnlk("0");
      this.jdField_a_of_type_Bnlk.jdField_b_of_type_Boolean = true;
      str = bnhh.c((bnhh)localObject, "0");
      localObject = bnhh.a((bnhh)localObject, "0");
      if ((TextUtils.isEmpty((CharSequence)localObject)) || (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext))) {
        break label110;
      }
      this.jdField_a_of_type_Bnlk.c = ((String)localObject);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bnlk.a(str);
      if (this.jdField_a_of_type_Bnlf == null) {
        this.jdField_a_of_type_Bnlf = new bnlf("2001");
      }
      return;
      label110:
      this.jdField_a_of_type_Bnlk.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846518);
    }
  }
  
  private static void b(bnln parambnln, DoodleEmojiItem paramDoodleEmojiItem)
  {
    parambnln.jdField_b_of_type_JavaLangString = paramDoodleEmojiItem.name;
    parambnln.c = paramDoodleEmojiItem.icon;
    parambnln.d = paramDoodleEmojiItem.download_icon;
    parambnln.g = paramDoodleEmojiItem.getLocalEmojiFolderPath();
    parambnln.e = paramDoodleEmojiItem.download_wording;
    parambnln.jdField_a_of_type_Boolean = "1".equals(paramDoodleEmojiItem.random_position);
    parambnln.a(paramDoodleEmojiItem.config);
    parambnln.jdField_a_of_type_Int = paramDoodleEmojiItem.hide;
    parambnln.jdField_b_of_type_Int = paramDoodleEmojiItem.mask;
  }
  
  public bndx a()
  {
    return this.jdField_a_of_type_Bndx;
  }
  
  public bnle a(String paramString)
  {
    return this.jdField_a_of_type_Bndx.a(paramString);
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Bnlk != null) {
      return this.jdField_a_of_type_Bnlk.f;
    }
    return null;
  }
  
  public List<bnle> a()
  {
    return a(false);
  }
  
  @NonNull
  public List<bnle> a(boolean paramBoolean)
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
        Object localObject1 = ((bnhh)vux.a(39)).a();
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
        localObject1 = ((Collection)localObject1).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localDoodleEmojiItem = (DoodleEmojiItem)((Iterator)localObject1).next();
        if (localDoodleEmojiItem.type == 1)
        {
          localObject3 = new bnln(localDoodleEmojiItem.pack_id);
          b((bnln)localObject3, localDoodleEmojiItem);
          if (("1".equals(((bnln)localObject3).jdField_a_of_type_JavaLangString)) && (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext))) {
            ((bnln)localObject3).jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846375);
          }
          this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(localObject3);
          continue;
        }
        if (localDoodleEmojiItem.type != 2) {
          break label398;
        }
      }
      finally {}
      this.jdField_a_of_type_Bnlk.jdField_b_of_type_JavaLangString = localDoodleEmojiItem.name;
      if ((!TextUtils.isEmpty(localDoodleEmojiItem.icon)) && (NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext))) {
        this.jdField_a_of_type_Bnlk.c = localDoodleEmojiItem.icon;
      }
      Object localObject4;
      while (localDoodleEmojiItem.mItemList != null)
      {
        this.jdField_a_of_type_Bnlk.jdField_a_of_type_JavaUtilList = localDoodleEmojiItem.mItemList;
        if (localDoodleEmojiItem.mItemList == null) {
          break;
        }
        xvv.b("PasterDataManager", "add doodle emoji location item name = " + this.jdField_a_of_type_Bnlk.f);
        localObject3 = localDoodleEmojiItem.mItemList.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (bnll)((Iterator)localObject3).next();
          ((bnll)localObject4).g = this.jdField_a_of_type_Bnlk.jdField_b_of_type_JavaLangString;
          ((bnll)localObject4).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Bnlk.f;
        }
        this.jdField_a_of_type_Bnlk.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846518);
      }
      this.jdField_a_of_type_Bnlk.jdField_a_of_type_Boolean = "1".equals(localDoodleEmojiItem.random_position);
      this.jdField_a_of_type_Bnlk.jdField_a_of_type_Int = localDoodleEmojiItem.hide;
      this.jdField_a_of_type_Bnlk.jdField_b_of_type_Int = localDoodleEmojiItem.mask;
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(this.jdField_a_of_type_Bnlk);
      continue;
      label398:
      if (localDoodleEmojiItem.type == 3)
      {
        if (this.jdField_a_of_type_Bnlf == null) {
          this.jdField_a_of_type_Bnlf = new bnlf(localDoodleEmojiItem.pack_id);
        }
        for (;;)
        {
          this.jdField_a_of_type_Bnlf.jdField_b_of_type_JavaLangString = localDoodleEmojiItem.name;
          this.jdField_a_of_type_Bnlf.jdField_a_of_type_JavaUtilList = localDoodleEmojiItem.mInfoItemList;
          this.jdField_a_of_type_Bnlf.a(localDoodleEmojiItem.config);
          this.jdField_a_of_type_Bnlf.jdField_a_of_type_Int = localDoodleEmojiItem.hide;
          this.jdField_a_of_type_Bnlf.g = "default";
          this.jdField_a_of_type_Bnlf.c = -999;
          this.jdField_a_of_type_Bnlf.h = "--";
          this.jdField_a_of_type_Bnlf.i = "default";
          if (this.jdField_a_of_type_Bnlf.jdField_a_of_type_JavaUtilList == null) {
            break;
          }
          localObject3 = this.jdField_a_of_type_Bnlf.jdField_a_of_type_JavaUtilList.iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (bnli)((Iterator)localObject3).next();
            ((bnli)localObject4).m = this.jdField_a_of_type_Bnlf.jdField_b_of_type_JavaLangString;
            if (bnlj.a(((bnli)localObject4).jdField_a_of_type_Int)) {
              ((bnli)localObject4).l = this.jdField_a_of_type_Bnlf.f;
            }
            if ((localDoodleEmojiItem.mCityRes != null) && (((bnli)localObject4).jdField_a_of_type_Int == 7)) {
              a(localDoodleEmojiItem.mCityRes, this.jdField_a_of_type_Bnlf.g, (bnli)localObject4);
            }
            if (((bnli)localObject4).jdField_a_of_type_Int == 6)
            {
              ((bnli)localObject4).c = this.jdField_a_of_type_Bnlf.c;
              ((bnli)localObject4).j = this.jdField_a_of_type_Bnlf.h;
              ((bnli)localObject4).k = this.jdField_a_of_type_Bnlf.i;
            }
          }
          this.jdField_a_of_type_Bnlf.jdField_a_of_type_JavaLangString = localDoodleEmojiItem.pack_id;
        }
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(this.jdField_a_of_type_Bnlf);
        this.jdField_a_of_type_Bnlf.jdField_a_of_type_JavaUtilMap = localDoodleEmojiItem.mCityRes;
      }
    }
    xvv.b("PasterDataManager", "getDoodleFacePackages, size = " + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
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
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void a(int paramInt, vww paramvww, List<TroopBarPOI> paramList)
  {
    xvv.b("PasterDataManager", "onPOIListRequestResult." + paramInt);
    if ((paramInt == 0) && (paramvww != null))
    {
      this.jdField_a_of_type_Vww = paramvww;
      if ((paramList != null) && (paramList.size() > 0))
      {
        paramvww = ((TroopBarPOI)paramList.get(0)).a();
        if (QLog.isColorLevel()) {
          QLog.d("PasterDataManager", 2, "onPOIListRequestResult " + paramvww);
        }
        String str = ShortVideoUtils.getRecentPOI(QQStoryContext.a().getCurrentAccountUin());
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext()) {
          if (((TroopBarPOI)localIterator.next()).a().equals(str)) {
            paramvww = str;
          }
        }
      }
    }
    for (;;)
    {
      a(((TroopBarPOI)paramList.get(0)).jdField_b_of_type_JavaLangString, paramvww, true);
      return;
    }
  }
  
  public void a(String paramString)
  {
    a(null, paramString, false);
  }
  
  public void a(vwp paramvwp)
  {
    this.jdField_a_of_type_Vvl = ((vvl)((vty)vux.a(20)).a(0));
    Object localObject = this.jdField_a_of_type_Vvl.a();
    if (localObject != null)
    {
      xvv.b("PasterDataManager", "get weather from cache.");
      a((vvo)localObject);
      return;
    }
    xvv.b("PasterDataManager", "get weather from net.");
    localObject = paramvwp;
    if (paramvwp == null) {
      localObject = vwq.a();
    }
    this.jdField_a_of_type_Vvl.a(this);
    this.jdField_a_of_type_Vvl.b((vwp)localObject);
  }
  
  public void a(boolean paramBoolean, Activity paramActivity)
  {
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Bnlf != null) && (!"default".equals(this.jdField_a_of_type_Bnlf.g)) && (!"--".equals(this.jdField_a_of_type_Bnlf.h))) {
      return;
    }
    new babh(paramActivity, new bmuc(this, paramBoolean)).a();
  }
  
  public void a(boolean paramBoolean, vvo paramvvo)
  {
    if (paramBoolean) {
      a(paramvvo);
    }
  }
  
  public void initIndeed()
  {
    this.jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.getContext();
    this.jdField_a_of_type_Bndx = new bndx();
    b();
    this.jdField_a_of_type_Bmue = new bmue(this);
    vli.a().registerSubscriber(this.jdField_a_of_type_Bmue);
    if (QLog.isDevelopLevel()) {
      QLog.d("PasterDataManager", 4, "initPasterConfig");
    }
  }
  
  public boolean isValidate()
  {
    return true;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Bmue != null)
    {
      vli.a().unRegisterSubscriber(this.jdField_a_of_type_Bmue);
      this.jdField_a_of_type_Bmue = null;
    }
    if (this.jdField_a_of_type_Vvl != null) {
      this.jdField_a_of_type_Vvl.b(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmua
 * JD-Core Version:    0.7.0.1
 */