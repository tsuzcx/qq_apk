import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.qflutter.resource_loader.NinePatchChunk;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.BaseConstantState;
import com.tencent.theme.SkinData;
import com.tencent.theme.SkinEngine;
import com.tencent.theme.SkinnableColorStateList;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import rx.Observable;
import rx.schedulers.Schedulers;

public class bbdu
  extends ViewModel
{
  private Bitmap a(Bitmap paramBitmap, String paramString)
  {
    Bitmap localBitmap = paramBitmap;
    if (paramString.endsWith(".9.png"))
    {
      localBitmap = paramBitmap;
      if (NinePatch.isNinePatchChunk(paramBitmap.getNinePatchChunk()))
      {
        paramString = NinePatchChunk.deserialize(paramBitmap.getNinePatchChunk());
        localBitmap = paramBitmap;
        if (paramString != null)
        {
          int j = paramBitmap.getWidth() + 2;
          int k = paramBitmap.getHeight() + 2;
          localBitmap = Bitmap.createBitmap(j, k, Bitmap.Config.ARGB_8888);
          Canvas localCanvas = new Canvas(localBitmap);
          localCanvas.translate(1.0F, 1.0F);
          localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, new Paint());
          int m = paramString.mPaddings.left;
          int n = paramString.mPaddings.right;
          int i1 = paramString.mPaddings.top;
          int i2 = paramString.mPaddings.bottom;
          int i = 1;
          while (i < Math.max(k, j) - 1)
          {
            if (a(paramString, i, true)) {
              localBitmap.setPixel(i, 0, -16777216);
            }
            if ((i > m) && (i < j - 1 - n)) {
              localBitmap.setPixel(i, k - 1, -16777216);
            }
            if (a(paramString, i, false)) {
              localBitmap.setPixel(0, i, -16777216);
            }
            if ((i > i1) && (i < k - 1 - i2)) {
              localBitmap.setPixel(j - 1, i, -16777216);
            }
            i += 1;
          }
        }
      }
    }
    return localBitmap;
  }
  
  private Bitmap a(bbdr parambbdr)
  {
    if (parambbdr != null)
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inScaled = false;
      if ((!ThemeUtil.isDefaultTheme()) && (!TextUtils.isEmpty(parambbdr.jdField_a_of_type_ComTencentThemeSkinData.mFilePath)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ResourceGrabViewModel", 2, "get theme package resource");
        }
        return BitmapFactory.decodeFile(parambbdr.jdField_a_of_type_ComTencentThemeSkinData.mFilePath, localOptions);
      }
      parambbdr = parambbdr.jdField_a_of_type_ComTencentThemeSkinData.mFileName.substring(0, parambbdr.jdField_a_of_type_ComTencentThemeSkinData.mFileName.indexOf("."));
      BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
      String str = localBaseApplication.getPackageName();
      int i = localBaseApplication.getResources().getIdentifier(parambbdr, "drawable", str);
      if (i > 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ResourceGrabViewModel", 2, "get system resource");
        }
        return BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), i, localOptions);
      }
    }
    return null;
  }
  
  private File a(String paramString)
  {
    return new File(BaseApplicationImpl.getContext().getExternalCacheDir(), "bitmapResource/" + paramString);
  }
  
  private String a(int paramInt)
  {
    Object localObject1 = BaseApplicationImpl.getContext().getResources();
    Object localObject2 = new TypedValue();
    ((Resources)localObject1).getValue(paramInt, (TypedValue)localObject2, true);
    if (((TypedValue)localObject2).type == 3) {
      try
      {
        localObject1 = ((Resources)localObject1).getAssets().openXmlResourceParser(((TypedValue)localObject2).assetCookie, ((TypedValue)localObject2).string.toString());
        localObject2 = Xml.asAttributeSet((XmlPullParser)localObject1);
        do
        {
          paramInt = ((XmlResourceParser)localObject1).next();
        } while ((paramInt != 2) && (paramInt != 1));
        if (paramInt != 2) {
          throw new XmlPullParserException("No start tag found");
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.d("ResourceGrabViewModel", 1, localThrowable, new Object[0]);
      }
    }
    while (!localThrowable.getName().equals("selector")) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
    localStringBuilder.append("<selector xmlns:android=\"http://schemas.android.com/apk/res/android\">\n");
    int k = localThrowable.getDepth() + 1;
    int i;
    int j;
    for (;;)
    {
      paramInt = localThrowable.next();
      if (paramInt == 1) {
        break;
      }
      i = localThrowable.getDepth();
      if ((i < k) && (paramInt == 3)) {
        break;
      }
      if ((paramInt == 2) && (i <= k) && (localThrowable.getName().equals("item")))
      {
        i = -65536;
        int m = ((AttributeSet)localObject2).getAttributeCount();
        localStringBuilder.append("<item ");
        paramInt = 0;
        if (paramInt < m)
        {
          j = ((AttributeSet)localObject2).getAttributeNameResource(paramInt);
          if (j != 0) {
            break label687;
          }
        }
        localStringBuilder.append(" />\n");
      }
    }
    for (;;)
    {
      localStringBuilder.append(" ");
      paramInt += 1;
      i = j;
      break;
      j = i;
      if (((AttributeSet)localObject2).getAttributeResourceValue(paramInt, 0) == 0)
      {
        j = ((AttributeSet)localObject2).getAttributeIntValue(paramInt, i);
        localStringBuilder.append("android:color=\"").append("#").append(Integer.toHexString(j)).append("\"");
        continue;
        localStringBuilder.append("android:state_window_focused=\"true\"");
        j = i;
        continue;
        localStringBuilder.append("android:state_window_focused=\"false\"");
        j = i;
        continue;
        localStringBuilder.append("android:state_selected=\"true\"");
        j = i;
        continue;
        localStringBuilder.append("android:state_selected=\"false\"");
        j = i;
        continue;
        localStringBuilder.append("android:state_focused=\"true\"");
        j = i;
        continue;
        localStringBuilder.append("android:state_focused=\"false\"");
        j = i;
        continue;
        localStringBuilder.append("android:state_enabled=\"true\"");
        j = i;
        continue;
        localStringBuilder.append("android:state_enabled=\"false\"");
        j = i;
        continue;
        localStringBuilder.append("android:state_pressed=\"true\"");
        j = i;
        continue;
        localStringBuilder.append("android:state_pressed=\"false\"");
        j = i;
        continue;
        localStringBuilder.append("android:state_checked=\"true\"");
        j = i;
        continue;
        localStringBuilder.append("android:state_checked=\"false\"");
        j = i;
        continue;
        localStringBuilder.append("android:state_activated=\"true\"");
        j = i;
        continue;
        localStringBuilder.append("android:state_activated=\"false\"");
        j = i;
        continue;
        localStringBuilder.append("android:state_accelerated=\"true\"");
        j = i;
        continue;
        localStringBuilder.append("android:state_accelerated=\"false\"");
        j = i;
        continue;
        localStringBuilder.append("android:state_hovered=\"true\"");
        j = i;
        continue;
        localStringBuilder.append("android:state_hovered=\"false\"");
        j = i;
        continue;
        localStringBuilder.append("android:state_drag_can_accept=\"true\"");
        j = i;
        continue;
        localStringBuilder.append("android:state_drag_can_accept=\"false\"");
        j = i;
        continue;
        localStringBuilder.append("android:state_drag_hovered=\"true\"");
        j = i;
        continue;
        localStringBuilder.append("android:state_drag_hovered=\"false\"");
        j = i;
        continue;
        localStringBuilder.append("</selector>");
        String str = localStringBuilder.toString();
        return str;
        label687:
        switch (j)
        {
        }
        j = i;
      }
    }
  }
  
  private List<bbdr> a(List<bbdr> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      HashSet localHashSet = new HashSet();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        bbdr localbbdr = (bbdr)paramList.next();
        if (!localHashSet.contains(localbbdr.jdField_a_of_type_ComTencentThemeSkinData.mFileName)) {
          localArrayList.add(localbbdr);
        }
        localHashSet.add(localbbdr.jdField_a_of_type_ComTencentThemeSkinData.mFileName);
      }
    }
    return localArrayList;
  }
  
  private void a(Drawable paramDrawable, List<bbdr> paramList, String paramString)
  {
    if ((paramDrawable != null) && (paramDrawable.getConstantState() != null) && (paramList != null))
    {
      paramDrawable = paramDrawable.getConstantState();
      if (!(paramDrawable instanceof BaseConstantState)) {
        break label82;
      }
      paramList.add(new bbdr(paramString, ((BaseConstantState)paramDrawable).skinData));
      if (QLog.isColorLevel()) {
        QLog.d("ResourceGrabViewModel", 2, "getFileNameByConstantState BaseConstantState resourceNames -> " + paramList);
      }
    }
    for (;;)
    {
      return;
      label82:
      if ((paramDrawable instanceof DrawableContainer.DrawableContainerState))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ResourceGrabViewModel", 2, "getFileNameByConstantState DrawableContainerState");
        }
        paramDrawable = ((DrawableContainer.DrawableContainerState)paramDrawable).getChildren();
        int j = paramDrawable.length;
        int i = 0;
        while (i < j)
        {
          Drawable localDrawable = paramDrawable[i];
          if (localDrawable != null) {
            a(localDrawable, paramList, paramString);
          }
          i += 1;
        }
      }
    }
  }
  
  private void a(View paramView, List<bbdr> paramList)
  {
    a(paramView.getBackground(), paramList, "background");
    if ((paramView instanceof ImageView)) {
      a(((ImageView)paramView).getDrawable(), paramList, "image_drawable");
    }
    do
    {
      do
      {
        return;
      } while (!(paramView instanceof TextView));
      Drawable[] arrayOfDrawable = ((TextView)paramView).getCompoundDrawables();
      int j = arrayOfDrawable.length;
      int i = 0;
      while (i < j)
      {
        a(arrayOfDrawable[i], paramList, "compound_drawable");
        i += 1;
      }
      paramView = ((TextView)paramView).getTextColors();
    } while (!(paramView instanceof SkinnableColorStateList));
    paramList.add(new bbdr("text_color", ((SkinnableColorStateList)paramView).skinData));
  }
  
  private void a(bbdr parambbdr, HashSet<String> paramHashSet)
  {
    if ((!ThemeUtil.isDefaultTheme()) && (!TextUtils.isEmpty(parambbdr.jdField_a_of_type_ComTencentThemeSkinData.mFilePath))) {
      paramHashSet.add(parambbdr.jdField_a_of_type_ComTencentThemeSkinData.mFilePath);
    }
    Object localObject;
    do
    {
      return;
      localObject = BaseApplicationImpl.getContext();
      String str1 = ((Context)localObject).getPackageName();
      String str2 = parambbdr.jdField_a_of_type_ComTencentThemeSkinData.mFileName.substring(0, parambbdr.jdField_a_of_type_ComTencentThemeSkinData.mFileName.indexOf("."));
      localObject = a(((Context)localObject).getResources().getIdentifier(str2, "color", str1));
    } while (TextUtils.isEmpty((CharSequence)localObject));
    if (QLog.isColorLevel()) {
      QLog.d("ResourceGrabViewModel", 2, "recoverColorXml content: \n " + (String)localObject);
    }
    parambbdr = b(parambbdr.jdField_a_of_type_ComTencentThemeSkinData.mFileName);
    paramHashSet.add(parambbdr.getAbsolutePath());
    try
    {
      if (!parambbdr.exists())
      {
        if (!parambbdr.getParentFile().exists()) {
          parambbdr.getParentFile().mkdir();
        }
        parambbdr.createNewFile();
      }
      parambbdr = new OutputStreamWriter(new FileOutputStream(parambbdr), "utf-8");
      parambbdr.write((String)localObject);
      parambbdr.flush();
      parambbdr.close();
      return;
    }
    catch (Exception parambbdr)
    {
      QLog.d("ResourceGrabViewModel", 1, parambbdr, new Object[0]);
    }
  }
  
  private void a(HashSet<String> paramHashSet)
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      paramHashSet = paramHashSet.iterator();
      while (paramHashSet.hasNext()) {
        localArrayList.add(new FileInfo((String)paramHashSet.next()));
      }
      ((anvu)BaseActivity.sTopActivity.app.a(8)).a(localArrayList);
    }
    catch (Exception paramHashSet)
    {
      QLog.d("ResourceGrabViewModel", 2, paramHashSet, new Object[0]);
      return;
    }
  }
  
  private boolean a(NinePatchChunk paramNinePatchChunk, int paramInt, boolean paramBoolean)
  {
    boolean bool = false;
    int i;
    if (paramBoolean)
    {
      paramNinePatchChunk = paramNinePatchChunk.mDivX;
      paramBoolean = bool;
      if (paramNinePatchChunk != null)
      {
        paramBoolean = bool;
        if (paramNinePatchChunk.length > 0) {
          i = 0;
        }
      }
    }
    for (;;)
    {
      paramBoolean = bool;
      if (i < paramNinePatchChunk.length - 1)
      {
        if ((paramInt > paramNinePatchChunk[i]) && (paramInt <= paramNinePatchChunk[(i + 1)])) {
          paramBoolean = true;
        }
      }
      else
      {
        return paramBoolean;
        paramNinePatchChunk = paramNinePatchChunk.mDivY;
        break;
      }
      i += 2;
    }
  }
  
  private File b(String paramString)
  {
    return new File(BaseApplicationImpl.getContext().getExternalCacheDir(), "xmlResource/" + paramString);
  }
  
  private void b(bbdr parambbdr, HashSet<String> paramHashSet)
  {
    Bitmap localBitmap = a(parambbdr);
    if (localBitmap != null)
    {
      localBitmap = a(localBitmap, parambbdr.jdField_a_of_type_ComTencentThemeSkinData.mFileName);
      parambbdr = a(parambbdr.jdField_a_of_type_ComTencentThemeSkinData.mFileName);
      paramHashSet.add(parambbdr.getAbsolutePath());
    }
    try
    {
      if (!parambbdr.exists())
      {
        if (!parambbdr.getParentFile().exists()) {
          parambbdr.getParentFile().mkdir();
        }
        parambbdr.createNewFile();
      }
      parambbdr = new FileOutputStream(parambbdr);
      localBitmap.compress(Bitmap.CompressFormat.PNG, 100, parambbdr);
      parambbdr.flush();
      parambbdr.close();
      return;
    }
    catch (Exception parambbdr)
    {
      QLog.d("ResourceGrabViewModel", 1, parambbdr, new Object[0]);
    }
  }
  
  public String a(List<bbdr> paramList)
  {
    paramList = a(paramList);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("rootPath: ").append(SkinEngine.getInstances().getSkinRootPath()).append("\n");
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      bbdr localbbdr = (bbdr)paramList.get(i);
      if (localbbdr != null)
      {
        localStringBuilder.append(localbbdr.jdField_a_of_type_JavaLangString).append(":").append(localbbdr.jdField_a_of_type_ComTencentThemeSkinData.mFileName);
        if (i != j - 1) {
          localStringBuilder.append("\n");
        }
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    Object localObject1;
    if ((paramView instanceof ViewGroup))
    {
      localObject1 = (ViewGroup)paramView;
      int j = ((ViewGroup)localObject1).getChildCount();
      int i = 0;
      while (i < j)
      {
        a(((ViewGroup)localObject1).getChildAt(i), paramBoolean);
        i += 1;
      }
    }
    Object localObject2;
    try
    {
      localObject1 = new ArrayList();
      a(paramView, (List)localObject1);
      if (((List)localObject1).isEmpty()) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ResourceGrabViewModel", 2, "doReplaceOnclickListener success fileName: " + localObject1 + ", view: " + paramView);
      }
      localObject2 = View.class.getDeclaredMethod("getListenerInfo", new Class[0]);
      if (!((Method)localObject2).isAccessible()) {
        ((Method)localObject2).setAccessible(true);
      }
      localObject2 = ((Method)localObject2).invoke(paramView, new Object[0]);
      Field localField = localObject2.getClass().getDeclaredField("mOnClickListener");
      localField.setAccessible(true);
      localObject2 = (View.OnClickListener)localField.get(localObject2);
      if (!paramBoolean)
      {
        if (!(localObject2 instanceof bbdz)) {
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ResourceGrabViewModel", 2, "recovery onClick listener");
        }
        localObject1 = (bbdz)localObject2;
        paramView.setOnClickListener(((bbdz)localObject1).jdField_a_of_type_AndroidViewView$OnClickListener);
        paramView.setClickable(((bbdz)localObject1).jdField_a_of_type_Boolean);
        return;
      }
    }
    catch (Throwable paramView)
    {
      QLog.d("ResourceGrabViewModel", 1, paramView, new Object[0]);
      return;
    }
    if ((!((List)localObject1).isEmpty()) && (!(localObject2 instanceof bbdz)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ResourceGrabViewModel", 2, "doReplace onClick listener");
      }
      paramView.setOnClickListener(new bbdz((List)localObject1, (View.OnClickListener)localObject2, paramView.isClickable()));
      paramView.setClickable(true);
    }
  }
  
  void a(List<bbdr> paramList)
  {
    if (!paramList.isEmpty())
    {
      HashSet localHashSet = new HashSet();
      Observable.from(paramList).distinct(new bbdy(this)).subscribeOn(Schedulers.io()).subscribe(new bbdv(this, localHashSet), new bbdw(this), new bbdx(this, localHashSet));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbdu
 * JD-Core Version:    0.7.0.1
 */