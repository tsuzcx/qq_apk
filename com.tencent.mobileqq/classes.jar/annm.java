import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionBase;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class annm
  extends annd
{
  public anht a;
  
  public annm(anht paramanht)
  {
    this.a = paramanht;
  }
  
  public int a(List<annd> paramList)
  {
    int i = 0;
    if (i < paramList.size())
    {
      Object localObject1 = (annd)paramList.get(i);
      Object localObject2;
      if ((localObject1 instanceof annm))
      {
        localObject1 = ((annm)localObject1).a;
        if ((!(localObject1 instanceof ankl)) || (!(this.a instanceof ankl))) {
          break label133;
        }
        localObject2 = ((ankl)localObject1).e;
        String str = ((ankl)this.a).e;
        if ((localObject2 != null) && (((String)localObject2).equals(str))) {}
        do
        {
          return i;
          localObject1 = ((ankl)localObject1).d;
          localObject2 = ((ankl)this.a).d;
        } while ((localObject1 != null) && (((String)localObject1).equals(localObject2)));
      }
      label133:
      label203:
      do
      {
        do
        {
          i += 1;
          break;
          if ((!(localObject1 instanceof anla)) || (!(this.a instanceof anla))) {
            break label203;
          }
          localObject1 = ((anla)localObject1).a;
          localObject2 = ((anla)this.a).a;
        } while ((localObject1 == null) || (localObject2 == null) || (((Emoticon)localObject1).eId == null) || (!((Emoticon)localObject1).eId.equals(((Emoticon)localObject2).eId)));
        return i;
      } while ((!(localObject1 instanceof anhh)) || (!(this.a instanceof anhh)) || (((anhh)localObject1).g != ((anhh)this.a).g));
      return i;
    }
    return 0;
  }
  
  public long a()
  {
    if ((this.a instanceof ankr)) {
      return ((ankr)this.a).a();
    }
    return 0L;
  }
  
  public Drawable a(Context paramContext)
  {
    URLDrawable localURLDrawable = null;
    if ((this.a instanceof anla)) {
      localURLDrawable = ((anla)this.a).a("fromAIO", true);
    }
    do
    {
      return localURLDrawable;
      if ((this.a instanceof ankl)) {
        return ((ankl)this.a).b(paramContext, paramContext.getResources().getDisplayMetrics().density, paramContext.getResources().getDisplayMetrics().widthPixels, paramContext.getResources().getDisplayMetrics().heightPixels);
      }
    } while (!(this.a instanceof anhh));
    return ((anhh)this.a).a(paramContext, paramContext.getResources().getDisplayMetrics().widthPixels, paramContext.getResources().getDisplayMetrics().heightPixels);
  }
  
  public anht a()
  {
    return this.a;
  }
  
  public CustomEmotionData a()
  {
    if (((this.a instanceof ankl)) && (((ankl)this.a).f != null))
    {
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface))
      {
        localObject = ((ancg)((QQAppInterface)localObject).getManager(149)).a();
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            CustomEmotionData localCustomEmotionData = (CustomEmotionData)((Iterator)localObject).next();
            if (((ankl)this.a).f.equalsIgnoreCase(localCustomEmotionData.resid)) {
              return localCustomEmotionData;
            }
          }
        }
      }
    }
    return null;
  }
  
  public void a(Bundle paramBundle, int paramInt)
  {
    super.a(paramBundle, paramInt);
    paramBundle.putInt("cur_emotion_id", (int)a());
    if ((this.a instanceof anhh)) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramBundle.putInt("cur_emotion_type", paramInt);
      return;
    }
  }
  
  public boolean a()
  {
    return this.a instanceof anla;
  }
  
  public boolean a(annd paramannd)
  {
    boolean bool = true;
    if ((paramannd instanceof annm))
    {
      paramannd = ((annm)paramannd).a;
      Object localObject;
      if (((paramannd instanceof ankl)) && ((this.a instanceof ankl)))
      {
        paramannd = ((ankl)paramannd).f;
        localObject = ((ankl)this.a).f;
        return (paramannd != null) && (paramannd.equals(localObject));
      }
      if (((paramannd instanceof anla)) && ((this.a instanceof anla)))
      {
        paramannd = ((anla)paramannd).a;
        localObject = ((anla)this.a).a;
        if ((paramannd != null) && (localObject != null) && (paramannd.eId != null) && (paramannd.eId.equals(((Emoticon)localObject).eId)) && (paramannd.epId != null) && (paramannd.epId.equals(((Emoticon)localObject).epId))) {}
        for (;;)
        {
          return bool;
          bool = false;
        }
      }
    }
    return false;
  }
  
  public annd b(Bundle paramBundle)
  {
    if (paramBundle.containsKey("cur_emotion_id"))
    {
      QLog.d("FavEmoticonPreviewData", 1, "doRestoreSaveInstanceState");
      int i = paramBundle.getInt("cur_emotion_type");
      int j = paramBundle.getInt("cur_emotion_id");
      paramBundle = BaseApplicationImpl.getApplication().getRuntime();
      if ((paramBundle instanceof QQAppInterface))
      {
        paramBundle = (QQAppInterface)paramBundle;
        if (i == 1) {}
        for (i = 333;; i = 149)
        {
          paramBundle = (anae)paramBundle.getManager(i);
          Object localObject = paramBundle.a();
          if ((localObject == null) || (((List)localObject).isEmpty())) {
            break;
          }
          localObject = ((List)localObject).iterator();
          CustomEmotionBase localCustomEmotionBase;
          do
          {
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            localCustomEmotionBase = (CustomEmotionBase)((Iterator)localObject).next();
          } while (localCustomEmotionBase.emoId != j);
          return new annm(paramBundle.a(localCustomEmotionBase));
        }
      }
    }
    return null;
  }
  
  public boolean b()
  {
    return true;
  }
  
  public boolean c()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     annm
 * JD-Core Version:    0.7.0.1
 */