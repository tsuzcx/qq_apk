import android.util.SparseArray;
import com.tencent.biz.qqcircle.list.bizblocks.QCircleHandler;
import com.tencent.common.app.AppInterface;
import com.tencent.device.file.DeviceFileHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RouterHandler;
import com.tencent.mobileqq.app.SignatureHandler;
import com.tencent.mobileqq.app.utils.PokeBigResHandler;
import com.tencent.mobileqq.mini.entry.MiniAppEntryHandler;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.msfmqpsdkbridge.MSFNetTransportProvider;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Constructor;
import java.util.ArrayList;

public class anue
{
  private static SparseArray<Class<? extends anud>> jdField_a_of_type_AndroidUtilSparseArray = new anuf(256);
  private static ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList = new BusinessHandlerFactory.2();
  
  public static anud a(int paramInt, QQAppInterface paramQQAppInterface)
  {
    long l1 = System.currentTimeMillis();
    if (jdField_a_of_type_AndroidUtilSparseArray.indexOfKey(paramInt) < 0)
    {
      QLog.e("BusinessHandlerFactory", 1, "First trigger lazyLoad, name=" + paramInt);
      a();
    }
    Object localObject = (Class)jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localObject == null)
    {
      QLog.e("BusinessHandlerFactory", 1, "Not Found Handler, name=" + paramInt);
      paramQQAppInterface = null;
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        long l2 = System.currentTimeMillis();
        QLog.d("BusinessHandlerFactory", 2, "createHandlerNew,costTime = [" + (l2 - l1) + "]");
      }
      return paramQQAppInterface;
      try
      {
        if (jdField_a_of_type_JavaUtilArrayList.contains(Integer.valueOf(paramInt)))
        {
          localObject = ((Class)localObject).getDeclaredConstructor(new Class[] { AppInterface.class });
          ((Constructor)localObject).setAccessible(true);
          paramQQAppInterface = (anud)((Constructor)localObject).newInstance(new Object[] { paramQQAppInterface });
        }
        else
        {
          localObject = ((Class)localObject).getDeclaredConstructor(new Class[] { QQAppInterface.class });
          ((Constructor)localObject).setAccessible(true);
          paramQQAppInterface = (anud)((Constructor)localObject).newInstance(new Object[] { paramQQAppInterface });
        }
      }
      catch (Exception paramQQAppInterface)
      {
        QLog.e("BusinessHandlerFactory", 1, paramQQAppInterface, new Object[0]);
        bdkh.a(paramQQAppInterface);
        paramQQAppInterface = null;
      }
    }
  }
  
  private static void a()
  {
    jdField_a_of_type_AndroidUtilSparseArray.put(159, boqe.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(92, axsc.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(3, aoat.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(4, anvl.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(6, anwo.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(7, aofu.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(8, anwa.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(12, anwx.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(15, aofw.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(16, anva.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(18, aohh.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(21, anwz.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(22, antz.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(23, aohr.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(24, aogy.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(26, aohx.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(27, aokv.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(28, aoju.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(33, aoct.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(34, aohe.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(35, anzp.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(37, nma.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(39, mvh.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(41, SignatureHandler.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(42, aofq.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(44, aokc.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(46, bikt.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(47, aoen.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(48, RouterHandler.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(49, abzb.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(50, DeviceFileHandler.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(51, abur.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(52, lge.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(53, antk.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(54, anux.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(56, aodd.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(57, aocv.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(58, aodf.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(59, apdn.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(60, axxj.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(62, apcc.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(63, MSFNetTransportProvider.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(64, tvl.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(68, oeo.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(66, axwo.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(70, aqks.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(72, anxd.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(73, aokl.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(74, aodm.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(71, VasExtensionHandler.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(79, baoh.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(80, asif.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(81, anze.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(85, bkib.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(86, aokj.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(89, aodb.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(90, odp.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(136, nyg.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(138, rqx.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(91, ayta.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(95, aqcd.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(93, oal.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(94, azct.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(96, aokx.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(97, aqhz.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(99, odn.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(98, wja.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(101, aqfw.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(104, bkhv.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(105, bkid.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(110, acvd.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(109, auvg.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(111, aokg.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(152, aoke.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(112, azww.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(113, ayxr.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(114, amrz.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(116, ho.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(117, PokeBigResHandler.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(118, apdx.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(119, aybu.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(120, beav.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(142, beaq.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(121, qtt.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(125, aqym.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(126, ucg.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(128, awjw.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(130, nqo.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(134, azou.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(135, aokz.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(139, oer.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(143, beee.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(145, awdn.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(146, blhs.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(147, aklf.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(149, MiniAppEntryHandler.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(150, avyk.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(151, bjyz.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(153, avgv.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(154, bdfv.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(155, ocw.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(156, awlt.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(158, ajib.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(157, bece.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(160, anuj.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(161, behk.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(162, axfx.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(163, tnv.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(164, awpq.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(165, bekh.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(166, bggi.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(167, axoq.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(168, aqrw.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(169, ajfp.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(170, avij.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(172, aobj.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(171, bgkq.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(175, avln.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(176, bmlf.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(177, bejm.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(178, mxm.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(179, bbcn.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(180, aogn.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(181, bapw.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(182, bajx.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(183, QCircleHandler.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(186, aqoy.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(185, bdvo.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(184, bemt.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anue
 * JD-Core Version:    0.7.0.1
 */