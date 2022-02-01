import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.List;

public class atie
  extends bbqp
{
  private BitmapFactory.Options a = new BitmapFactory.Options();
  
  public atie(aobu paramaobu)
  {
    super(paramaobu);
  }
  
  public void a(bbmy parambbmy, bbvg parambbvg)
  {
    parambbvg.a().setMaxWidth(800);
    Object localObject = (athz)parambbmy;
    ImageView localImageView = parambbvg.b();
    localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    localImageView.setImageDrawable(null);
    localImageView.setBackgroundDrawable(null);
    if (((athz)localObject).a == null) {
      return;
    }
    FileManagerEntity localFileManagerEntity = (FileManagerEntity)((athz)localObject).a.get(0);
    int i = atvo.a(localFileManagerEntity.fileName);
    if ((i == 0) || (i == 2))
    {
      if (bgmg.b(localFileManagerEntity.strThumbPath)) {
        localObject = localFileManagerEntity.strThumbPath;
      }
      for (;;)
      {
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = parambbvg.b().getHeight();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = parambbvg.b().getWidth();
        parambbvg = parambbvg.d();
        if ((parambbvg != null) && (!TextUtils.isEmpty(parambbmy.d())))
        {
          parambbvg.setText(parambbmy.d());
          parambbvg.setVisibility(0);
        }
        parambbmy = atwg.a(localFileManagerEntity);
        if (parambbmy == null) {
          break;
        }
        parambbmy = URLDrawable.getDrawable(parambbmy, (URLDrawable.URLDrawableOptions)localObject);
        if (parambbmy == null) {
          localImageView.setImageDrawable(localImageView.getContext().getResources().getDrawable(2130844302));
        }
        localImageView.setImageDrawable(parambbmy);
        return;
        if (bgmg.b(localFileManagerEntity.strLargeThumPath))
        {
          localObject = localFileManagerEntity.strLargeThumPath;
        }
        else
        {
          if (!bgmg.b(localFileManagerEntity.getFilePath())) {
            break label265;
          }
          localFileManagerEntity.getFilePath();
        }
      }
      label265:
      localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (localFileManagerEntity.getCloudType() == 1) {
        localObject = ((QQAppInterface)localObject).a().a(localFileManagerEntity, 7);
      }
    }
    for (;;)
    {
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        localImageView.setImageDrawable(BaseApplicationImpl.getContext().getResources().getDrawable(2130844302));
        return;
        if (localFileManagerEntity.getCloudType() == 2) {
          localObject = ((QQAppInterface)localObject).a().a(localFileManagerEntity.WeiYunFileId, localFileManagerEntity.strLargeThumPath, 3, localFileManagerEntity);
        }
      }
      else
      {
        localFileManagerEntity.strThumbPath = ((String)localObject);
        break;
        atvo.a(localImageView, localFileManagerEntity);
        return;
      }
      localObject = "";
    }
  }
  
  public void b(bbmy parambbmy, bbvg parambbvg)
  {
    super.b(parambbmy, parambbvg);
    if ((parambbvg.a() != null) && (!TextUtils.isEmpty(parambbmy.a())))
    {
      parambbvg.a().setVisibility(0);
      parambbvg.a().setText(parambbmy.a());
    }
    if ((parambbvg.b() != null) && (!TextUtils.isEmpty(parambbmy.b())))
    {
      parambbvg.b().setVisibility(0);
      parambbvg.b().setText(parambbmy.b());
    }
    if ((parambbvg.c() != null) && (!TextUtils.isEmpty(parambbmy.c())))
    {
      parambbvg.c().setVisibility(0);
      parambbvg.c().setText(parambbmy.c());
    }
    if ((parambbmy.d() == null) && (parambbvg.d() != null)) {
      parambbvg.d().setVisibility(8);
    }
    if ((parambbvg.d() != null) && (parambbmy.d() != null))
    {
      parambbvg.d().setVisibility(0);
      parambbvg.d().setText(parambbmy.d());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atie
 * JD-Core Version:    0.7.0.1
 */