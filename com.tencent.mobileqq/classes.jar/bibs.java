class bibs
  implements bisp<Boolean, bisu>
{
  bibs(bibq parambibq) {}
  
  public Void a(Boolean paramBoolean, bisu parambisu)
  {
    if ((!paramBoolean.booleanValue()) || (parambisu == null) || (parambisu.jdField_a_of_type_AndroidGraphicsBitmap == null))
    {
      urk.e("Q.qqstory.record.EditLocalVideoPlayer", "Generate thumbnail error! thumbnail = (null)");
      return null;
    }
    urk.b("Q.qqstory.record.EditLocalVideoPlayer", "Generate thumbnail index = %d", Integer.valueOf(parambisu.jdField_a_of_type_Int));
    if (parambisu.jdField_a_of_type_Int >= this.a.a.length)
    {
      urk.e("Q.qqstory.record.EditLocalVideoPlayer", "Generate thumbnail index = %d OutOfArrayBounds", new Object[] { Integer.valueOf(parambisu.jdField_a_of_type_Int) });
      return null;
    }
    urk.b("Q.qqstory.record.EditLocalVideoPlayer.Flow", "thumbnailProgress index: %d thumbnail done!", Integer.valueOf(parambisu.jdField_a_of_type_Int));
    this.a.a[parambisu.jdField_a_of_type_Int] = bibt.a(this.a.a[parambisu.jdField_a_of_type_Int], parambisu.jdField_a_of_type_AndroidGraphicsBitmap);
    this.a.a[parambisu.jdField_a_of_type_Int].jdField_a_of_type_JavaLangString = parambisu.jdField_a_of_type_JavaLangString;
    this.a.j();
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bibs
 * JD-Core Version:    0.7.0.1
 */