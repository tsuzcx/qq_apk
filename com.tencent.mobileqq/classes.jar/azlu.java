import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.profilecard.bussiness.colorscreen.ProfileColorScreenComponent;

public class azlu
{
  public static azlv a(int paramInt, azlw paramazlw, azfe paramazfe)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileComponentFactory", 0, String.format("create componentType=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
    azlv localazlv = azqh.a(paramInt, paramazlw, paramazfe);
    if (QLog.isColorLevel()) {
      QLog.d("ProfileComponentFactory", 0, String.format("create from vas component factory. component=%s", new Object[] { localazlv }));
    }
    Object localObject = localazlv;
    if (localazlv == null) {
      switch (paramInt)
      {
      default: 
        QLog.e("ProfileComponentFactory", 1, String.format("invalid component type, componentType=%s", new Object[] { Integer.valueOf(paramInt) }));
        paramazlw = localazlv;
      }
    }
    for (;;)
    {
      localObject = paramazlw;
      if (QLog.isColorLevel())
      {
        QLog.d("ProfileComponentFactory", 0, String.format("create from base component factory. component=%s", new Object[] { paramazlw }));
        localObject = paramazlw;
      }
      return localObject;
      paramazlw = new azlj(paramazlw, paramazfe);
      continue;
      paramazlw = new azlh(paramazlw, paramazfe);
      continue;
      paramazlw = new azlg(paramazlw, paramazfe);
      continue;
      paramazlw = new azli(paramazlw, paramazfe);
      continue;
      paramazlw = new azlk(paramazlw, paramazfe);
      continue;
      paramazlw = new azla(paramazlw, paramazfe);
      continue;
      paramazlw = new ProfileColorScreenComponent(paramazlw, paramazfe);
      continue;
      paramazlw = new azpa(paramazlw, paramazfe);
      continue;
      paramazlw = new azob(paramazlw, paramazfe);
      continue;
      paramazlw = new aznj(paramazlw, paramazfe);
      continue;
      paramazlw = new aznv(paramazlw, paramazfe);
      continue;
      paramazlw = new azos(paramazlw, paramazfe);
      continue;
      paramazlw = new azoi(paramazlw, paramazfe);
      continue;
      paramazlw = new azol(paramazlw, paramazfe);
      continue;
      paramazlw = new azow(paramazlw, paramazfe);
      continue;
      paramazlw = new aznl(paramazlw, paramazfe);
      continue;
      paramazlw = new azog(paramazlw, paramazfe);
      continue;
      paramazlw = new azpb(paramazlw, paramazfe);
      continue;
      paramazlw = new azoh(paramazlw, paramazfe);
      continue;
      paramazlw = new azou(paramazlw, paramazfe);
      continue;
      paramazlw = new aznt(paramazlw, paramazfe);
      continue;
      paramazlw = new azpe(paramazlw, paramazfe);
      continue;
      paramazlw = new aznp(paramazlw, paramazfe);
      continue;
      paramazlw = new azne(paramazlw, paramazfe);
      continue;
      paramazlw = new aznh(paramazlw, paramazfe);
      continue;
      paramazlw = new azna(paramazlw, paramazfe);
      continue;
      paramazlw = new azmz(paramazlw, paramazfe);
      continue;
      paramazlw = new azod(paramazlw, paramazfe);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azlu
 * JD-Core Version:    0.7.0.1
 */